/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controllers;

import java.awt.Point;
import java.util.List;
import lml.FactoryGiver;
import model.dishobjects.alive.Bacterium;
import specialization.Specialization;

/**
 * Контроллер игрока
 */
public class PlayerController implements Controller {

    @Override
    public void update(Bacterium bacterium) {
        if (FactoryGiver.getFactory().getGameIO().isBolidThrowingAsked()) {
            throwBolid(FactoryGiver.getFactory().getGameIO().getMousePosition(), bacterium);
        }
            
        // Запросить координаты мыши
        Point mousePosition = FactoryGiver.getFactory().getGameIO().getMousePosition();
        
        // Установить текущие координаты мыши как точку назначения
        bacterium.setDestination(mousePosition);
    }

    @Override
    public void chooseSpecialization(List<Specialization> availableUpgrades, Bacterium bacterium) {
        bacterium.setSpecialization(FactoryGiver.getFactory().getGameIO().askForSpecialization(availableUpgrades));
    }

    @Override
    public void throwBolid(Point p, Bacterium bacterium) {
        bacterium.throwBolid(p);
    }
}
