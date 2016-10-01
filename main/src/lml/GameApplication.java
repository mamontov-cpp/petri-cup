/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lml;

import java.awt.Graphics2D;
import model.GameModel;
import view.GameView;

/**
 * Класс игрового приложения
 */
public abstract class GameApplication {
    
    /**
     * Размеры приложения
     */
    public static int screenWidth = 1024,
        screenHeight = 720;
    
    /**
     * Модель игры
     */
    protected GameModel model = new GameModel();
    /**
     * Представление игры
     */
    protected GameView view;
    
    /**
     * Начало игры
     */
    public abstract void start();
            
    /**
     * Обновление игры
     */
    public void update(long l)
    {
        model.update(l);
    }
    
    /**
     * Рендеринг окна игры
     */
    public void render(Graphics2D gd)
    {
        view.render(gd);
    }
    
    /**
     * Получить модель игры
     * @return модель игры
     */
    public GameModel getGameModel() {
        return model;
    }
}
