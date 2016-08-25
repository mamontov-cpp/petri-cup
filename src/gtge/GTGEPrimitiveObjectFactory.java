/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtge;

import java.awt.Point;
import model.Dish;
import model.dishobjects.PrimitiveObjectFactory;
import model.dishobjects.primitive.Agar;
import model.dishobjects.primitive.PrimitiveObject;

/**
 * Фабрика примитивных объектов GTGE
 */
public class GTGEPrimitiveObjectFactory extends PrimitiveObjectFactory {

    @Override
    public Agar createAgar(Point position) {
        // Создать агар
        Agar agar = new Agar(new GTGESprite());
        
        // Завершить создание
        finishCreation(agar, position);
        
        return agar;
    }
    
    /**
     * Завершить создание объекта
     * @param obj созданный объект
     */
    private void finishCreation(PrimitiveObject obj, Point position) {
        // Сообщить о создании объекта
        fireDishObjectCreated(obj);
        
        // Добавить объект на чашку Петри
        if (position == null)
            Dish.instance.addObject(obj);
        else
            Dish.instance.addObject(obj, position);
    }
}
