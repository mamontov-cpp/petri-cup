/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import model.dishobjects.DishObject;

/**
 * Слушатель события удаления объекта
 */
public interface DishObjectRemovedListener {
    
    /**
     * Событие удаления объекта
     * @param obj удаленный объект
     */
    public void dishObjectRemoved(DishObject obj);
}
