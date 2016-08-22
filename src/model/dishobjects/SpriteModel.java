/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects;

import java.awt.Point;

/**
 * Модель спрайта объекта
 */
public interface SpriteModel {
    /**
     * Задать позицию спрайта
     * @param position позиция спрайта
     */
    public void setPosition(Point position);
    /**
     * Получить позицию спрайта
     * @return позиция спрайта
     */
    public Point getPosition();
    /**
     * Задать скорость спрайта
     * @param speed скорость спрайта
     */
    public void setSpeed(double speed);
    /**
     * Получить скорость спрайта
     * @return скорость спрайта
     */
    public double getSpeed();
    /**
     * Установить направление движения
     * @param angle угол относительно восточного направления
     */
    public void setDirection(int angle);
    /**
     * Получить направление движения
     * @return угол относительно восточного направления
     */
    public int getDirection();
    /**
     * Обновление спрайта
     * @param l время с последнего обновления
     */
    public void update(long l);
}
