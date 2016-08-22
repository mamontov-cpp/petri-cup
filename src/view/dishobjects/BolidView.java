/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dishobjects;

import java.awt.Color;
import lml.FactoryGiver;
import model.dishobjects.alive.Bolid;
import view.SpriteView;

/**
 * Представление болида
 */
public class BolidView extends AliveObjectView {
    
    public BolidView(Bolid obj, SpriteView spriteView) {
        super(obj, spriteView, FactoryGiver.getFactory().getGame().getGameModel().isPlayer(obj.getParent()) ? Color.YELLOW : Color.PINK);
    }
}
