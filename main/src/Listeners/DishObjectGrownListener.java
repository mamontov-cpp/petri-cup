/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import model.dishobjects.alive.AliveObject;

/**
 * Слушатель события роста объекта
 */
public interface DishObjectGrownListener {
    public void growed(AliveObject aliveObject);
}
