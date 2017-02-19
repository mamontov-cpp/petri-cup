package engine;
/**
 * Главный класс игры
 */
public class Game extends  com.golden.gamedev.Game {
    
    /**
     * Инициализация ресурсов игры
     */
    @Override
    public void initResources() { 
        
    }
    
    /**
     * Обновляет состояние игры
     * @param elapsedTime время, прошедшее с предыдущего обновления
     */
    @Override
    public void update(long elapsedTime) {
        
    }
    
    /**
     * Отрисовывет состояние игры (не портировать)
     * @param g 
     */
    @Override
    public void render(java.awt.Graphics2D g) {
        engine.Graphics2D ctx = new engine.Graphics2D(g);
        renderInContext(ctx);
    }
    
    /**
     * Отрисовывет состояние игры
     * @param g 
     */    
    public void renderInContext(engine.Graphics2D g) {
        
    }
}
