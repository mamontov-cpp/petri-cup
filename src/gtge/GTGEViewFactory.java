/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtge;

import model.dishobjects.*;
import model.dishobjects.alive.*;
import model.dishobjects.primitive.*;
import view.ViewFactory;
import view.dishobjects.*;

/**
 * Фабрика представлений объектов GTGE
 */
public class GTGEViewFactory extends ViewFactory {

    @Override
    protected void createView(DishObject obj) {
        // Получить спрайт
        GTGESprite sprite = (GTGESprite)obj.getSpriteModel();
        
        DishObjectView view = null;
        if (obj instanceof PrimitiveObject)
            view = new PrimitiveObjectView((PrimitiveObject) obj, sprite);
        else if (obj instanceof Bacterium)
            view = new BacteriumView((Bacterium) obj, sprite);
        else if (obj instanceof Bolid)
            view = new BolidView((Bolid)obj, sprite);
        
        // Сообщить о создании представления объекта
        fireDishObjectViewCreated(view);
    }
}