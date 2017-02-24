package game.controllers;

import game.Game;
import game.Sprite;

/**
 * Базовый контроллер для спрайта - отвечает за внутреннюю его логику
 */
public class Controller {
    
    public Controller(Game game, Sprite s) {
        this.sprite = s;
        this.game = game;
    }
    
    /**
     * Базовая реализация лишь проверяет, что спрайт не вышел за поля
     * @param elapsedTime 
     */
    public void update(long elapsedTime) {
        // Проверить на выход за границы поля
        //this.sprite.stopOnGoingOutOfBounds((double)(Game.totalWidth), (double)(Game.totalHeight));
    }
    
    
    Sprite sprite;
    
    Game game;
}
