/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dishobjects;

import java.awt.Color;
import model.dishobjects.DishObject;
import model.dishobjects.primitive.*;
import view.SpriteView;

/**
 * Представление примитивного объекта
 */
public class PrimitiveObjectView extends DishObjectView {

    public PrimitiveObjectView(PrimitiveObject obj, SpriteView spriteView) {
        super(obj, spriteView, getObjectColor(obj));
    }
    
    /**
     * Возвращает цвет для переданного объекта
     * @param obj объект, для которого требуется цвет
     * @return цвет объекта
     */
    private static Color getObjectColor(DishObject obj) {
        if (obj instanceof Agar)
            return Color.GRAY;
        
        return null;
    }
}
