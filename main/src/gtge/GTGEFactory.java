/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtge;

import lml.Factory;
import lml.GameApplication;
import lml.GameIO;
import model.CollisionManager;
import model.dishobjects.AliveObjectFactory;
import model.dishobjects.PrimitiveObjectFactory;
import view.ViewFactory;

/**
 * Фобрика объектов библиотеки GTGE
 */
public class GTGEFactory extends Factory {
    
    private GTGEGame game;
    private GTGECollisionManager collisionManager;
    private GTGEViewFactory viewFactory;
    private GTGEPrimitiveObjectFactory primitiveObjectFactory;
    private GTGEAliveObjectFactory aliveObjectFactory;
    
    @Override
    public CollisionManager getCollisionManager() {
        if (collisionManager == null)
            collisionManager = new GTGECollisionManager();
        return collisionManager;
    }

    @Override
    public ViewFactory getViewFactory() {
        if (viewFactory == null) {
            viewFactory = new GTGEViewFactory();
            getPrimitiveObjectFactory().addDishObjectCreatedListener(viewFactory);
            getAliveObjectFactory().addDishObjectCreatedListener(viewFactory);
        }
        return viewFactory;
    }

    @Override
    public AliveObjectFactory getAliveObjectFactory() {
        if (aliveObjectFactory == null)
            aliveObjectFactory = new GTGEAliveObjectFactory();
        return aliveObjectFactory;
    }

    @Override
    public PrimitiveObjectFactory getPrimitiveObjectFactory() {
        if (primitiveObjectFactory == null)
            primitiveObjectFactory = new GTGEPrimitiveObjectFactory();
        return primitiveObjectFactory;
    }

    @Override
    public GameApplication getGame() {
        if (game == null)
            game = new GTGEGame();
        return game;
    }

    @Override
    public GameIO getGameIO() {
        if (game == null)
            game = new GTGEGame();
        return game;
    }
}
