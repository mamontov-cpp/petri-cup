/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects;

import java.awt.Point;

/**
 * Объект на чашке Петри
 */
public abstract class DishObject {
    
    /**
     * Максимально допустимая скорость объекта
     */
    private final int MAX_SPEED = 25;
    
    /**
     * Максимальное значение энергии
     */
    private final int MAX_ENERGY = 1;
    
    /**
     * Коэффициент изменения энергии относительно массы объекта
     */
    private final double ENERGY_DECREASE_COEFFICIENT = 0.0006;
    
    /**
     * Масса объекта
     */
    protected int mass;
    
    /**
     * Энергия перемещения объекта
     */
    protected double energy = 0;
    
    public DishObject(SpriteModel spriteModel) {
        this.spriteModel = spriteModel;
    }
    
    /**
     * Модель спрайта объекта
     */
    protected SpriteModel spriteModel;
    
    public void update(long l) {
        // Изменить скорость относительно текущей массы и энергии
        spriteModel.setSpeed(MAX_SPEED / (double) (mass * 2) * energy);
        // Уменьшить энергию
        energy = Math.max(0, energy - mass * ENERGY_DECREASE_COEFFICIENT);
        // Обновить модель спрайта
        spriteModel.update(l);
    }

    /**
     * Столкновение с другим объектом
     * @param obj объект, с которым произошло столкновение
     */
    public abstract void collide(DishObject obj);
    
    /**
     * Вернуть модель спрайта
     * @return модель спрайта
     */
    public SpriteModel getSpriteModel() {
        return spriteModel;
    }
    
    /**
     * Вернуть массу объекта
     * @return масса объекта
     */
    public int getMass() {
        return mass;
    }
    
    /**
     * Делегирует запрос позиции модели
     * @return позиция объекта
     */
    public Point getPosition() {
        return spriteModel.getPosition();
    }
    
    /**
     * Установить позицию объекта на чашке
     * @param pos позиция объекта
     */
    public void setPosition(Point pos) {
        spriteModel.setPosition(pos);
    }
    
    /**
     * Установить направление движения
     * @param angle угол относительно восточного направления
     */
    public void setDirection(int angle) {
        // Освежить энергию
        energy = MAX_ENERGY;
        
        // Задать направление
        spriteModel.setDirection(angle);
    }
}