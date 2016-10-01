/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lml;

import model.CollisionManager;
import model.dishobjects.AliveObjectFactory;
import model.dishobjects.PrimitiveObjectFactory;
import view.ViewFactory;

/**
 * Фабрика библиотечных объектов
 */
public abstract class Factory {

    /**
     * Получить менеджер коллизий (если еще не создан, то создается)
     * @return менеджер коллизий
     */
    public abstract CollisionManager getCollisionManager();
    
    /**
     * Получить фабрику классов представления (если еще не создана, то создается)
     * @return фабрика классов представления
     */ 
    public abstract ViewFactory getViewFactory();
    
    /**
     * Получить фабрику живых объектов (если еще не создана, то создается)
     * @return фабрика живых объектов
     */ 
    public abstract AliveObjectFactory getAliveObjectFactory();
    
    /**
     * Получить фабрику примитивных объектов (если еще не создана, то создается)
     * @return фабрика примитивных объектов
     */ 
    public abstract PrimitiveObjectFactory getPrimitiveObjectFactory();
    
    /**
     * Получить класс игрового приложения (если еще не создан, то создается)
     * @return класс игрового приложения
     */ 
    public abstract GameApplication getGame();
    
    /**
     * Получить класс игрового ввода/вывода
     * @return класс игрового ввода/вывода
     */ 
    public abstract GameIO getGameIO();
}
