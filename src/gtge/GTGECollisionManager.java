/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtge;

import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import model.CollisionManager;
import model.dishobjects.DishObject;

/**
 * Менеджер коллизий объектов GTGE
 */
public class GTGECollisionManager extends CollisionManager {
    
    /**
     * Группа объектов, участвующих в коллизиях
     */
    private SpriteGroup spriteGroup = new SpriteGroup("Objects");
    
    /**
     * Модуль обнаружения коллизий
     */
    private CollisionGroup cg;
    
    public GTGECollisionManager() {
        // Инициализировать модуль обнаружения коллизий
        cg = new CollisionGroup(spriteGroup, spriteGroup);
    }
    
    @Override
    public void addObject(DishObject obj) {
        // Добавить объект в группу объектов, участвующих в коллизиях
        spriteGroup.add((Sprite) obj.getSpriteModel());
        
        super.addObject(obj);
    }

    @Override
    public void removeObject(DishObject obj) {
        // Удалить объект из группы объектов, участвующих в коллизиях
        spriteGroup.remove((Sprite) obj.getSpriteModel());
        
        super.removeObject(obj);
    }
    
    @Override
    public void checkCollision() {
        cg.checkCollision();
    }
    
    /**
     * Установить фон для группы объектов
     * @param bg фон
     */
    public void setBackground(Background bg) {
        spriteGroup.setBackground(bg);
    }
    
    private class CollisionGroup extends BasicCollisionGroup {

        public CollisionGroup(SpriteGroup g1, SpriteGroup g2) {
            setCollisionGroup(g1, g2);
            pixelPerfectCollision = true;
        }
    
        @Override
        public void collided(Sprite first, Sprite second) {
            GTGECollisionManager.this.collided((GTGESprite) first, (GTGESprite)second);
        }   
    }
}
