package engine;

import java.awt.image.BufferedImage;

/**
 * Фон для игры
 */
public class ImageBackground extends com.golden.gamedev.object.background.ImageBackground {

    public ImageBackground(BufferedImage bi) {
        super(bi);
    }
    
    /**
     * Устанавливает обрезку фона
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    @Override
    public  void setClip(int x, int y, int width, int height) {
        super.setClip(x, y, width, height);
    }
    
    /**
     * Устанавливает глобальные пределы смещения камеры
     * @param totalWidth
     * @param totalHeight 
     */
    public void setTotalClip(int totalWidth, int totalHeight) {
        
    }
    
    /**
     * Обновление состояния фона
     * @param elapsed 
     */
    @Override
    public void update(long elapsed) {
        super.update(elapsed);
    }
    
    /**
     * Отрисовка фона
     * @param g 
     */
    public void render(Graphics2D g) {
        super.render(g.get());
    }
    
    /**
     * Устанавливает центра фона в определенную позицию
     * @param s 
     */
    public void setToCenter(Sprite s) {
        super.setToCenter(s);
    }
    
    /**
     * Возвращает позицию X смещения фона
     * @return 
     */
    @Override
    public double getX() {
        return super.getX();
    }

    /**
     * Возвращает позицию Y смещения фона
     * @return 
     */    
    @Override
    public double getY() {
        return super.getY();
    }
}
