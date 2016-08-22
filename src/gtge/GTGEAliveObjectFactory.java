/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtge;

import model.Dish;
import model.dishobjects.AliveObjectFactory;
import model.dishobjects.alive.Bacterium;
import model.dishobjects.alive.Bolid;
import specialization.Specialization;

/**
 * Фабрика живых объектов GTGE
 */
public class GTGEAliveObjectFactory extends AliveObjectFactory {

    @Override
    public Bacterium createBacterium(Specialization spec) {
        // Создать бактерию
        Bacterium bacterium = new Bacterium(new GTGESprite());
        bacterium.setSpecialization(spec);
        
        // Сообщить о создании бактерии
        fireDishObjectCreated(bacterium);
        
        // Добавить бактерию на чашку Петри
        Dish.instance.addObject(bacterium);
        
        return bacterium;
    }

    @Override
    public Bolid createBolid(Bacterium parent, int mass) {
        // Создать болид
        Bolid bolid = new Bolid(new GTGESprite(), parent, mass);
        
        // Сообщить о создании бактерии
        fireDishObjectCreated(bolid);
        
        // Добавить бактерию на чашку Петри
        Dish.instance.addObject(bolid, parent.getPosition());
        
        return bolid;
    }
}
