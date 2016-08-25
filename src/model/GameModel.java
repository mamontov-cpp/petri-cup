/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.Point;
import java.util.List;
import lml.FactoryGiver;
import model.controllers.*;
import model.dishobjects.alive.AliveObject;
import model.dishobjects.DishObject;
import model.dishobjects.alive.Bacterium;

/**
 * Модель игры
 */
public class GameModel  {
    
    /**
     * Начальное количество света
     */
    final int INITIAL_LIGHT_COUNT = 20;
    
    /**
     * Начальное количество агара
     */
    final int INITIAL_AGAR_COUNT = 20;
    
    /**
     * Начальное количество воды
     */
    final int INITIAL_WATER_COUNT = 20;
    
    /**
     * Начальное количество бактерий
     */
    final int INITIAL_BACTERIUM_COUNT = 5;
    	
    /** 
    * Вероятность создания нового объекта свет за один кадр
    */ 
    final double LIGHT_PROBABILITY = 0.03; 

    /** 
    * Вероятность создания нового объекта агар за один кадр
    */ 
    final double AGAR_PROBABILITY = 0.03; 

    /** 
    * Вероятность создания нового объекта вода за один кадр
    */ 
    final double WATER_PROBABILITY = 0.03;

    /** 
    * Вероятность создания новой бактерии за один кадр
    */ 
    final double BACTERIUM_PROBABILITY = 0.005;
    
    /**
     * Бактерия игрока
     */
    private Bacterium player;
    
    /**
     * Контроллер игрока
     */
    private Controller playerController = new PlayerController();
    
    /**
     * Контроллер компьютерных бактерий
     */
    private Controller aiController = new AIController();
    
    /**
     * Начать игру
     */
    public void start() {
        
        player = FactoryGiver.getFactory().getAliveObjectFactory().createBacterium();
        
        for (int i = 0; i < INITIAL_LIGHT_COUNT; ++i)
            FactoryGiver.getFactory().getPrimitiveObjectFactory().createLight();
        for (int i = 0; i < INITIAL_WATER_COUNT; ++i)
            FactoryGiver.getFactory().getPrimitiveObjectFactory().createWater();
        for (int i = 0; i < INITIAL_AGAR_COUNT; ++i)
            FactoryGiver.getFactory().getPrimitiveObjectFactory().createAgar();
        for (int i = 0; i < INITIAL_BACTERIUM_COUNT; ++i)
            FactoryGiver.getFactory().getAliveObjectFactory().createBacterium();
    }
    
    /**
     * Обновление
     * @param l врямя с предыдущего обновления
     */
    public void update(long l) {
        // Применить управление к игроку
        playerController.update(player);
        
        for (int i = 0; i < Dish.instance.getObjects().size(); ++i) {
            // Применить управление к компьютерным бактериям
            if (Dish.instance.getObjects().get(i) instanceof Bacterium && Dish.instance.getObjects().get(i) != player)
                aiController.update((Bacterium) Dish.instance.getObjects().get(i));
            Dish.instance.getObjects().get(i).update(l);
        }
        
        // Определить коллизии
        FactoryGiver.getFactory().getCollisionManager().checkCollision();
        
        // Создание новых объектов
        if (Math.random() < LIGHT_PROBABILITY) { 
            FactoryGiver.getFactory().getPrimitiveObjectFactory().createLight(); 
        } 
        if (Math.random() < AGAR_PROBABILITY) { 
            FactoryGiver.getFactory().getPrimitiveObjectFactory().createAgar(); 
        } 
        if (Math.random() < WATER_PROBABILITY) { 
            FactoryGiver.getFactory().getPrimitiveObjectFactory().createWater(); 
        }
        if (Math.random() < BACTERIUM_PROBABILITY) {
            FactoryGiver.getFactory().getAliveObjectFactory().createBacterium();
        }
    }
    
    /**
     * Возвращает признак того, что переданная бактерия находится под управлением игрока
     * @param bacterium проверяемая бактерия
     * @return признак того, что переданная бактерия находится под управлением игрока
     */
    public boolean isPlayer(Bacterium bacterium) {
        return bacterium == player;
    }
}