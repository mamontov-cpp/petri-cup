/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.dishobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import model.dishobjects.DishObject;
import view.SizeConverter;
import view.SpriteView;

/**
 * Представление объекта на чашке Петри
 */
public abstract class DishObjectView {
    
    /**
     * Объект, которому принадлежит представление
     */
    private DishObject dishObject;
    
    /**
     * Представление спрайта
     */
    protected SpriteView spriteView;
    
    protected DishObjectView(DishObject obj, SpriteView spriteView, Color color) {
        dishObject = obj;
        this.spriteView = spriteView;
        
        // Задать размер
        spriteView.setSize(SizeConverter.massToSize(obj.getMass()));
        
        // Задать цвет
        spriteView.setColor(color);
    }

    public void render(Graphics2D gd) {
        spriteView.render(gd);
    }
    
    /**
     * Получить объект, к которому относится данное представление
     * @return модель объекта на чашке Петри
     */
    public DishObject getDishObject() {
        return dishObject;
    }
}
