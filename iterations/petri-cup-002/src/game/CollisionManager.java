package game;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import java.awt.Point;

/**
 * Менеджер коллизий 
 */
public class CollisionManager {
        
    /**
     * Модуль обнаружения коллизий объект - бочка
     */
    private final ObjectToBarrelCollisionGroup o2b;
    /**
     * Модуль обнаружения коллизий объект - агар
     */
    private final ObjectToAgarCollisionGroup o2a;

    /**
     * Группа для агара
     */
    private final SpriteGroup agarGroup;
    /**
     * Игра
     */
    private final Game game;
    
    public CollisionManager(
        Game game,
        SpriteGroup playerGroup, 
        SpriteGroup barrelGroup,
        SpriteGroup agarGroup) {
        this.game = game;
        this.agarGroup = agarGroup;
        // Инициализировать модуль обнаружения коллизий
        o2b = new ObjectToBarrelCollisionGroup(playerGroup, barrelGroup);
        o2a = new ObjectToAgarCollisionGroup(playerGroup, agarGroup);
    }
    
    public void collidedObjectToBarrel(Sprite first, Sprite second) {
        first.setX(first.getOldX());
        first.setY(first.getOldY());        
    }
    
    public void collidedObjectToAgar(Sprite first, Sprite second) {
        if (first == game.playerSprite()) {
            game.incrementCollectedAgar();
            agarGroup.remove(second);
        }
    }
    
    /**
     * Проверяет коллизии для менеджера
     */
    public void checkCollision() {
        o2b.checkCollision();
        o2a.checkCollision();
    }
    
    
    private class ObjectToBarrelCollisionGroup extends BasicCollisionGroup {

        public ObjectToBarrelCollisionGroup(SpriteGroup g1, SpriteGroup g2) {
            setCollisionGroup(g1, g2);
            pixelPerfectCollision = true;
        }
    
        @Override
        public void collided(Sprite first, Sprite second) {
            CollisionManager.this.collidedObjectToBarrel(first, second);
        }   
    }
    
    private class ObjectToAgarCollisionGroup extends BasicCollisionGroup {

        public ObjectToAgarCollisionGroup(SpriteGroup g1, SpriteGroup g2) {
            setCollisionGroup(g1, g2);
            pixelPerfectCollision = true;
        }
    
        @Override
        public void collided(Sprite first, Sprite second) {
            CollisionManager.this.collidedObjectToAgar(first, second);
        }   
    }
}
