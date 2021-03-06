/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtge;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JOptionPane;
import lml.GameApplication;
import lml.GameIO;

/**
 * Мост для GTGE игры
 */
public class GTGEGame extends GameApplication implements GameIO {
    
    private GameExtender ge;
    
    public GTGEGame() {
        // Задать представление
        view = new GTGEGameView();
    }

    @Override
    public void start() {
        // Инициализировать модель игры
        model.start();
        
        // Запустить игру
        GameLoader game = new GameLoader();
        ge = new GameExtender();
        game.setup(ge, new Dimension(screenWidth, screenHeight), false);
        game.start();
    }
    
    @Override
    public Point getMousePosition() {
        Point mousePosition = ge.getMousePosition();
        
        // Запросить координаты фона
        Point backgroundPosition = view.getBackgroundCoordinates();
        
        return new Point(mousePosition.x + backgroundPosition.x, mousePosition.y + backgroundPosition.y);
    }

    @Override
    public BufferedImage getImage(String path) {
        return ge.getImage(path);
    }
    
    @Override
    public boolean isBolidThrowingAsked() {
        return ge.isKeyPressed(KeyEvent.VK_SPACE);
    }
    
    public class GameExtender extends Game {
        @Override
        public void initResources() {
        }
        
        @Override
        public void update(long l) {
            GTGEGame.this.update(l);
        }

        @Override
        public void render(Graphics2D gd) {
            GTGEGame.this.render(gd);
        }
        
        private Point getMousePosition() {
            return new Point(bsInput.getMouseX(), bsInput.getMouseY());
        }
        
        private boolean isKeyPressed(int key) {
            return bsInput.isKeyPressed(key);
        }
    }
}
