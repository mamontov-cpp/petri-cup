/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Окно игры
 */
public abstract class GameView {
    
    /**
     * Представление чашки Петри
     */
    protected DishView dishView;
    
    /**
     * Отрисовка окна игры
     */
    public abstract void render(Graphics2D gd);
    
    /**
     * Получить координаты фона
     * @return координаты фона
     */
    public Point getBackgroundCoordinates() {
        return dishView.getBackgroundCoordinates();
    }
}
