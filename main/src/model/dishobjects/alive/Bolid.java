/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dishobjects.alive;

import lml.GameMath;
import model.dishobjects.DishObject;
import model.dishobjects.SpriteModel;

/**
 * Болид, выплёвываемый бактерией
 */
public class Bolid extends AliveObject {

    /**
     * Бактерия-родитель
     */
    private Bacterium parent;
    
    /**
     * Флаг доступности поглощения родителем во избежание моментального поедания
     */
    private boolean absorbable;
    
    public Bolid(SpriteModel spriteModel, Bacterium parent, int mass) {
        super(spriteModel);
        this.parent = parent;
        this.mass = mass;
        
        // После создания нельзя сразу поглотить
        absorbable = false;
    }
    
    @Override
    public void update(long l) {
        // Если болид пролетел достаточное расстояние от родителя после плевка,
        // разрешить его поглощать
        if (destination != null) {
            if (GameMath.distance(getPosition().x, getPosition().y, destination.x, destination.y) < MIN_MOVE_DISTANCE)
                absorbable = true;
        }
        
        super.update(l);
    }
    
    /**
     * Возвращает родителя болида
     * @return родитель болида
     */
    public Bacterium getParent() {
        return parent;
    }
    
    /**
     * Возвращает возможность поглощения болида бактерией
     * @param absorber бактерия, пытающаяся поглотить болид
     * @return признак доступности абсолбации
     */
    public boolean absorbable(Bacterium absorber) {
        return absorber == parent && absorbable;
    }
    
    @Override
    public void collide(DishObject obj) {
        if (obj instanceof Bacterium && obj != parent && obj.getMass() > mass)
        {
            setDestination(GameMath.getOppositePoint(destination, getPosition()));
            ((Bacterium)obj).throwBolid(mass - 1, destination);
        }
        else if (obj instanceof Bolid && obj.getMass() <= mass)
            absorb((Bolid)obj);
        else
            super.collide(obj);
    }
}
