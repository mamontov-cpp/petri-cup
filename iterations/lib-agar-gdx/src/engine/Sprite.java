
package engine;

/**
 * Класс спрайта
 */
public class Sprite {

    /**
     * Обновление состояние спрайта
     * @param elapsed прошедшее время
     */
    public void update(long elapsed) {

    }
    
    /**
     * Рисует спрайт на изображении
     * @param g 
     */
    public void render(Graphics2D g) {

    }    
    
    /**
     * Возвращает фигуру для коллизии
     * @return 
     */
    public engine.collision.Ellipse getCollisionShape() {
        return new engine.collision.Ellipse(0, 0, 2, 1);        
    }
    
}
