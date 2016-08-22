/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dishobjects.alive;

import java.awt.Point;
import lml.FactoryGiver;
import lml.GameMath;
import model.Dish;
import model.dishobjects.DishObject;
import model.dishobjects.SpriteModel;

/**
 * Бактерия
 */
public class Bacterium extends AliveObject {
    
    /**
     * Начальная масса объекта
     */
    private final int initialMass = 50;
    
    public Bacterium(SpriteModel spriteModel) {
        super(spriteModel);
        mass = initialMass;
    }
    
    /**
     * Выплёвывание болида
     * @param mass масса болида
     * @param destination точка, в направлении которой полетит болид
     */
    public void throwBolid(int mass, Point destination) {
        // Не позволять создать болид, если масса бактерии станет меньше минимальной
        if (this.mass - mass < initialMass / 2) {
            return;
        }
        FactoryGiver.getFactory().getAliveObjectFactory().createBolid(this, mass).setDestination(destination);
        
        // меньшить массу
        setMass(this.mass - mass);
    }
    
    /**
     * Выплёвывание болида, инициированное самой бактерией
     * @param destination точка, в направлении которой полетит болид
     */
    public void throwBolid(Point destination) {
        throwBolid(mass / 3, destination);
    }

    @Override
    public void collide(DishObject obj) {
        if (obj instanceof Bolid) {
            if (((Bolid)obj).getParent() == this) {
                if (((Bolid)obj).absorbable(this))
                   absorb((Bolid) obj);
            }
        }
        else
            super.collide(obj);
    }
}
