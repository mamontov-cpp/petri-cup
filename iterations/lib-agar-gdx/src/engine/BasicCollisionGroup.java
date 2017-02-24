package engine;

import java.util.List;

/**
 * Группа для поиска пересечений
 */
public class BasicCollisionGroup {
    /**
     * Инициализация коллизий
     */
    public BasicCollisionGroup() {

    }
    
    /**
     * Запускает проверку коллизий для спрайтов
     */
    public void checkCollision() {
        if (m_group1 != null && m_group2 != null) {
            List<Sprite> sprites1 = m_group1.toList();
            List<Sprite> sprites2 = m_group2.toList();
            for (Sprite s1 : sprites1) {
                for (Sprite s2 : sprites2) {
                    if (s1 != s2) {
                        if (s1.getCollisionShape().collidesWith(s2.getCollisionShape())) {
                            this.collided(s1, s2);
                        }
                    }
                }
            }
        }
    }
    
    public void setCollisionGroup(SpriteGroup s1, SpriteGroup s2) {
        m_group1 = s1;
        m_group2 = s2;
    }
        
    
    /**
     * Обрабатывает коллизии.
     * @param first
     * @param second 
     */
    public void collided(Sprite first, Sprite second) {
        
    }
    
    /**
     * Первая группа для определения пересечений
     */
    SpriteGroup m_group1;
    
    /**
     * Вторая группа для определения пересечений
     */
    SpriteGroup m_group2;    
}