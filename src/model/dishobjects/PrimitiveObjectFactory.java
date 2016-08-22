/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects;

import java.awt.Point;
import model.dishobjects.primitive.Agar;
import model.dishobjects.primitive.CarbonDioxyde;
import model.dishobjects.primitive.Light;
import model.dishobjects.primitive.Oxygen;
import model.dishobjects.primitive.PrimitiveObject;
import model.dishobjects.primitive.Water;

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
     * Создаёт воду
     * @return вода
     */
    public Water createWater() {
        return createWater(null);
    }
    
    /**
     * Создаёт воду в заданной позиции
     * @param position позиция воды
     * @return вода
     */
    public abstract Water createWater(Point position);
    
    /**
     * Создаёт свет
     * @return свет
     */
    public Light createLight() {
        return createLight(null);
    }
    
    /**
     * Создаёт свет в заданной позиции
     * @param position позиция света
     * @return свет
     */
    public abstract Light createLight(Point position);
    
    /**
     * Создаёт углекислый газ
     * @return углекислый газ
     */
    public CarbonDioxyde createCarbonDioxyde() {
        return createCarbonDioxyde(null);
    }
    
    /**
     * Создаёт углекислый газ в заданной позиции
     * @param position позиция углекислого газа
     * @return углекислый газ
     */
    public abstract CarbonDioxyde createCarbonDioxyde(Point position);
    
    /**
     * Создаёт кислород
     * @return кислород
     */
    public Oxygen createOxygen() {
        return createOxygen(null);
    }
    
    /**
     * Создаёт кислород в заданной позиции
     * @param position позиция кислорода
     * @return кислород
     */
    public abstract Oxygen createOxygen(Point position);
    
    /**
     * Создаёт примитивный объект переданного класса в заданной позиции
     * @param primitiveObjectClass класс примитивного объекта
     * @return созданный примитивный объект
     */
    public PrimitiveObject createPrimitiveObject(Class primitiveObjectClass, Point position) {
        if (primitiveObjectClass == Agar.class)
            return createAgar(position);
        if (primitiveObjectClass == Water.class)
            return createWater(position);
        if (primitiveObjectClass == Light.class)
            return createLight(position);
        if (primitiveObjectClass == CarbonDioxyde.class)
            return createCarbonDioxyde(position);
        if (primitiveObjectClass == Oxygen.class)
            return createOxygen(position);
        return null;
    }
}