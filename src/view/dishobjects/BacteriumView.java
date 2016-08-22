/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dishobjects;

import Listeners.DishObjectGrownListener;
import Listeners.SpecializationChangedListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.dishobjects.alive.AliveObject;
import model.dishobjects.alive.Bacterium;
import specialization.Specialization;
import view.SizeConverter;
import view.SpriteView;

/**
 * Представление бактерии
 */
public class BacteriumView extends AliveObjectView implements SpecializationChangedListener {

    public BacteriumView(Bacterium obj, SpriteView spriteView) {      
        super(obj, spriteView, Color.GREEN);
        
        // Подписаться на событие изменения специализации
        obj.addSpecializationChangedListener(this);
    }

    @Override
    public void specializationChanged() {
        spriteView.setIcon(getAvatarForSpecialization(((Bacterium)getDishObject()).getSpecialization()));
    }
}