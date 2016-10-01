/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects;

import java.awt.Point;
import model.dishobjects.primitive.Agar;
import model.dishobjects.primitive.PrimitiveObject;

/**
 * Фабрика примитивных объектов
 */
public abstract class PrimitiveObjectFactory extends DishObjectFactory {
    
    /**
     * Создаёт агар
     * @return агар
     */
    public Agar createAgar() {
        return createAgar(null);
    }
    
    /**
     * Создаёт агар в заданной позиции
     * @param position позиция агара
     * @return агар
     */
    public abstract Agar createAgar(Point position);
        
    /**
     * Создаёт примитивный объект переданного класса в заданной позиции
     * @param primitiveObjectClass класс примитивного объекта
     * @return созданный примитивный объект
     */
    public PrimitiveObject createPrimitiveObject(Class primitiveObjectClass, Point position) {
        if (primitiveObjectClass == Agar.class)
            return createAgar(position);
        return null;
    }
}