/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects;

import java.awt.Point;
import model.dishobjects.alive.Bacterium;
import model.dishobjects.alive.Bolid;

/**
 * Фабрика живых объектов
 */
public abstract class AliveObjectFactory extends DishObjectFactory {
    
    /**
     * Создать бактерию с заданной специализацией
     * @return созданная бактерия
     */
    public abstract Bacterium createBacterium();
    
    /**
     * Создать болид
     * @param parent бактерия-родитель болида
     * @param mass масса создаваемого болида
     * @return созданный болид
     */
    public abstract Bolid createBolid(Bacterium parent, int mass);
}
