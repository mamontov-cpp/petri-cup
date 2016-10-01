/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listeners;

import model.dishobjects.DishObject;

/**
 * Слушатель события создания объекта
 */
public interface DishObjectCreatedListener {
    
    /**
     * Событие создания объекта
     * @param obj созданный объект
     */
    public void dishObjectCreated(DishObject obj);
}
