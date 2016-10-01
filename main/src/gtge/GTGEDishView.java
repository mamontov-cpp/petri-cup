/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtge;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.background.ImageBackground;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import lml.FactoryGiver;
import model.dishobjects.alive.Bacterium;
import view.DishView;

/**
 * Представление поля GTGE
 */
public class GTGEDishView extends DishView {
    
    public GTGEDishView() {
        // Установить фон
        try {
            bg = new ImageBackground(ImageIO.read(new File("resources/background.jpg")));
            ((GTGECollisionManager)FactoryGiver.getFactory().getCollisionManager()).setBackground(bg);
            bg.setClip(0, 0, GTGEGame.screenWidth, GTGEGame.screenHeight);
        } catch (IOException ex) {
            Logger.getLogger(Bacterium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void repaint(Graphics2D gd) {
        bg.render(gd);
        bg.setToCenter((Sprite) player.getSpriteModel());
    }
}
