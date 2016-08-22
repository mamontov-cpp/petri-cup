/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dishobjects;

import Listeners.DishObjectGrownListener;
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
 * Представление движущегося (живого) объекта
 */
public class AliveObjectView extends DishObjectView implements DishObjectGrownListener {
    
    public AliveObjectView(AliveObject obj, SpriteView spriteView, Color color) {
        super(obj, spriteView, color);
        
        // Задать иконку
        spriteView.setIcon(getAvatarForSpecialization(obj.getSpecialization()));
        
        // Подписаться на событие роста
        obj.addDishObjectGrownListener(this);
    }
    
    /**
     * Получить иконку для специализации
     * @param spec специализация, для которой требуется иконка
     * @return иконка для специализации
     */
    protected BufferedImage getAvatarForSpecialization(Specialization spec) {
        BufferedImage avatar = null;
        String path = "resources/avatars/" + spec.getName().toUpperCase() + ".png";
        path = path.replace(' ', '_');
        try {
            avatar = ImageIO.read(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(Bacterium.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return avatar;
    }

    @Override
    public void growed(AliveObject aliveObject) {
        spriteView.setSize(SizeConverter.massToSize(aliveObject.getMass()));
    }
}
