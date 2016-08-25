/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dishobjects;

import java.awt.Color;
import model.dishobjects.alive.Bacterium;
import view.SpriteView;

/**
 * Представление бактерии
 */
public class BacteriumView extends AliveObjectView {

    public BacteriumView(Bacterium obj, SpriteView spriteView) {      
        super(obj, spriteView, Color.GREEN);
    }
    
}