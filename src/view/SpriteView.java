/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Представление спрайта
 */
public interface SpriteView {
    
    /**
     * Установить цвет объекта
     * @param color цвет объекта
     */
    public void setColor(Color color);
    
    /**
     * Установить иконку объекта
     * @param icon иконка объекта
     */
    public void setIcon(BufferedImage icon);
    
    /**
     * Задать размеры объекта
     * @param r радиус
     */
    public void setSize(int r);
    
    public void render(Graphics2D gd);
}
