/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtge;

import java.awt.Point;
import model.Dish;
import model.dishobjects.PrimitiveObjectFactory;
import model.dishobjects.primitive.Agar;
import model.dishobjects.primitive.CarbonDioxyde;
import model.dishobjects.primitive.Light;
import model.dishobjects.primitive.Oxygen;
import model.dishobjects.primitive.PrimitiveObject;
import model.dishobjects.primitive.Water;

/**
 * Фабрика примитивных объектов GTGE
 */
public class GTGEPrimitiveObjectFactory extends PrimitiveObjectFactory {

    @Override
    public Agar createAgar(Point position) {
        // Создать агар
        Agar agar = new Agar(new GTGESprite());
        
        // Завершить создание
        finishCreation(agar, position);
        
        return agar;
    }

    @Override
    public Water createWater(Point position) {
        // Создать воду
        Water water = new Water(new GTGESprite());
        
        // Завершить создание
        finishCreation(water, position);
        
        return water;
    }

    @Override
    public Light createLight(Point position) {
        // Создать свет
        Light light = new Light(new GTGESprite());
        
        // Завершить создание
        finishCreation(light, position);
        
        return light;
    }

    @Override
    public CarbonDioxyde createCarbonDioxyde(Point position) {
        // Создать углекислый газ
        CarbonDioxyde сarbonDioxyde = new CarbonDioxyde(new GTGESprite());
        
        // Завершить создание
        finishCreation(сarbonDioxyde, position);
        
        return сarbonDioxyde;
    }

    @Override
    public Oxygen createOxygen(Point position) {
        // Создать кислород
        Oxygen oxygen = new Oxygen(new GTGESprite());
        
        // Завершить создание
        finishCreation(oxygen, position);
        
        return oxygen;
    }
    
    /**
     * Завершить создание объекта
     * @param obj созданный объект
     */
    private void finishCreation(PrimitiveObject obj, Point position) {
        // Сообщить о создании объекта
        fireDishObjectCreated(obj);
        
        // Добавить объект на чашку Петри
        if (position == null)
            Dish.instance.addObject(obj);
        else
            Dish.instance.addObject(obj, position);
    }
}
