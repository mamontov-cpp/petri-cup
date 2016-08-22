/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects;

import java.awt.Point;
import model.dishobjects.alive.Bacterium;
import model.dishobjects.alive.Bolid;
import specialization.Specialization;
import specialization.SpecializationTree;

/**
 * Фабрика живых объектов
 */
public abstract class AliveObjectFactory extends DishObjectFactory {
    
    /**
     * Создать бактерию с заданной специализацией
     * @param spec специализация создаваемой бактерии
     * @return созданная бактерия
     */
    public abstract Bacterium createBacterium(Specialization spec);
    
    /**
     * Создать бактерию с начальной специализацией
     * @return созданная бактерия
     */
    public Bacterium createBacterium() {
        return createBacterium(SpecializationTree.instance.getInitialSpecialization());
    }
    
    /**
     * Создать болид
     * @param parent бактерия-родитель болида
     * @param mass масса создаваемого болида
     * @return созданный болид
     */
    public abstract Bolid createBolid(Bacterium parent, int mass);
}
