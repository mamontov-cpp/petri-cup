/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controllers;

import java.awt.Point;
import java.util.List;
import java.util.Random;
import lml.FactoryGiver;
import lml.GameApplication;
import model.Dish;
import model.dishobjects.alive.Bacterium;

/**
 * Контроллер компьютерных бактерий
 */
public class AIController implements Controller {
    
    /**
     * Вероятность смены направления на каждом кадре
     */
    private final double CHANGE_DESTINATION_PROBABILITY = 0.015;
    
    /**
     * Вероятность выплёвывания болида
     */
    private final double THROW_BOLID_PROBABILITY = 0.0005;
    
    /**
     * Минимальная дистанция плевка болида
     */
    private final int MINIMAL_THROW_DISTANCE = 200;

    @Override
    public void update(Bacterium bacterium) {
        Random rand = new Random();
        if (Math.random() < CHANGE_DESTINATION_PROBABILITY) {
            // Сгенерировать случайные новые координаты перемещения
            bacterium.setDestination(new Point(rand.nextInt(Dish.fieldWidth), rand.nextInt(Dish.fieldHeight)));
        }
        if (Math.random() < THROW_BOLID_PROBABILITY) {
            int throwX = bacterium.getPosition().x + rand.nextInt(GameApplication.screenWidth - 2 * MINIMAL_THROW_DISTANCE) / 2 + MINIMAL_THROW_DISTANCE;
            int throwY = bacterium.getPosition().y + rand.nextInt(GameApplication.screenHeight - 2 * MINIMAL_THROW_DISTANCE) / 2 + MINIMAL_THROW_DISTANCE;
            throwBolid(new Point(throwX, throwY), bacterium);
        }
    }

    @Override
    public void throwBolid(Point p, Bacterium bacterium) {
        bacterium.throwBolid(p);
    }
}
