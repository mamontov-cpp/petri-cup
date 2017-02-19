package engine;

/**
 * Группа для поиска пересечений
 */
public class BasicCollisionGroup extends com.golden.gamedev.object.collision.BasicCollisionGroup {
    
    /**
     * Инициализация коллизий
     */
    public BasicCollisionGroup() {
        super();
        this.pixelPerfectCollision = true;
    }
    
    /**
     * Запускает проверку коллизий для спрайтов
     */
    @Override
    public void checkCollision() {
        super.checkCollision();
    }
    
    public void setCollisionGroup(SpriteGroup s1, SpriteGroup s2) {
        super.setCollisionGroup(s1, s2);
    }
    
    /**
     * Обрабатывает коллизии. Не переносить!
     * @param first
     * @param second 
     */
    @Override
    public void collided(com.golden.gamedev.object.Sprite first, com.golden.gamedev.object.Sprite second) {
        this.collided((Sprite)first, (Sprite)second);
    }
    
    
    /**
     * Обрабатывает коллизии.
     * @param first
     * @param second 
     */
    public void collided(Sprite first, Sprite second) {
        
    }
}
