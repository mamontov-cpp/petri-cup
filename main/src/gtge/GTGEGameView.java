/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtge;

import java.awt.Graphics2D;
import view.GameView;

/**
 * Класс игрового окна GTGE
 */
public class GTGEGameView extends GameView {

    public GTGEGameView() {
        dishView = new GTGEDishView();
    }
    
    @Override
    public void render(Graphics2D gd) {
        dishView.render(gd);
    }
}
