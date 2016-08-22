/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import view.dishobjects.DishObjectView;
import Listeners.DishObjectCreatedListener;
import Listeners.DishObjectViewCreatedListener;
import java.util.ArrayList;
import java.util.List;
import model.dishobjects.DishObject;

/**
 * Фабрика представлений объектов
 */
public abstract class ViewFactory implements DishObjectCreatedListener {
    
    /**
     * Слушатели события создания объекта
     */
    private List <DishObjectViewCreatedListener> dishObjectViewCreatedListeners = new ArrayList<DishObjectViewCreatedListener>();
    
    /**
     * Создание представления объекта
     * @param obj объект, для которого создаётся представление
     */
    protected abstract void createView(DishObject obj);
    
    /**
     * Событие создания объекта
     * @param obj созданный объект
     */
    @Override
    public void dishObjectCreated(DishObject obj) {
        createView(obj);
    }
    
    /**
     * Добавление слушателя
     * @param listener добавляемый слушатель
     */
    public void addDishObjectViewCreatedListener(DishObjectViewCreatedListener listener) {        
        dishObjectViewCreatedListeners.add(listener);
    }
    
    /**
     * Посылка сообщений о создании представления объекта всем слушателям
     * @param view созданное представление
     */
    protected void fireDishObjectViewCreated(DishObjectView view) {
        for (DishObjectViewCreatedListener listener : dishObjectViewCreatedListeners)
            listener.dishObjectViewCreated(view);
    }
}