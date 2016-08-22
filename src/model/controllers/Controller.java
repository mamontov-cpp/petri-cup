/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controllers;

import java.awt.Point;
import java.util.List;
import model.dishobjects.alive.Bacterium;
import specialization.Specialization;

/**
 * Интерфейс контроллера
 */
public interface Controller {
    
    /**
     * Применить управление к переданной бактерии
     * @param bacterium бактерия, к которой необходимо применить управление
     */
    public void update(Bacterium bacterium);
    
    /**
     * Выбрать новую специализацию для объекта
     * @param availableUpgrades список доступных специализаций для обновления
     * @param bacterium бактерия, для которой выбирается специализация
     */
    public void chooseSpecialization(List <Specialization> availableUpgrades, Bacterium bacterium);
    
    /**
     * Выплюнуть болид в направлении заданной точки
     * @param p точка, в направлении которой необходимо выплюнуть болид
     * @param bacterium бактерия, которая выплёвывает болид
     */
    public void throwBolid(Point p, Bacterium bacterium);
}
