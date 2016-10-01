/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects.primitive;

import model.dishobjects.DishObject;
import model.dishobjects.SpriteModel;

/**
 * Примитивный объект
 */
public class PrimitiveObject extends DishObject {
    
    /**
     * Начальная масса объекта
     */
    private final int initialMass = 20;
    
    public PrimitiveObject(SpriteModel spriteModel) {
        super(spriteModel);
        mass = initialMass;
    }

    @Override
    public void collide(DishObject obj) {
        
    }
}
