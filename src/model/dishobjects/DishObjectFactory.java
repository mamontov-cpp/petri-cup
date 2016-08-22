/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects;

import Listeners.DishObjectCreatedListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Базовый класс фабрик объектов
 */
public abstract class DishObjectFactory {
    /**
     * Слушатели события создания объекта
     */
    private List <DishObjectCreatedListener> dishObjectCreatedListeners = new ArrayList<DishObjectCreatedListener>();
    
    /**
     * Добавление слушателя
     * @param listener добавляемый слушатель
     */
    public void addDishObjectCreatedListener(DishObjectCreatedListener listener) {        
        dishObjectCreatedListeners.add(listener);
    }
    
    /**
     * Посылка сообщений о создании объекта всем слушателям
     * @param obj созданный объект
     */
    protected void fireDishObjectCreated(DishObject obj) {
        for (DishObjectCreatedListener listener : dishObjectCreatedListeners)
            listener.dishObjectCreated(obj);
    }
}
