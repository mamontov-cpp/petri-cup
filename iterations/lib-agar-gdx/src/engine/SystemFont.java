package engine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


/**
 * Системный шрифт для отрисовки надписей
 */
public class SystemFont {
    /**
     * Создает новый системный шрифт
     * @param fontName имя
     * @param attrs атрибуты
     * @param size размер шрифта
     * @param clr  цвет
     */
    public SystemFont(String fontName, int attrs, int size, java.awt.Color clr) {
        m_font = new BitmapFont();
        m_font.setColor(new Color(clr.getRGB()));
    }
    
    /**
     * Рисует строку с заданным значением строки
     * @param g контекст
     * @param data данные
     * @param x координата X
     * @param y координата Y
     */
    public void drawString(Graphics2D g, String data, int x, int y) {
        m_font.draw(g.getBatch(), data, x, y);
    }
    
    /**
     * A font
     */
    BitmapFont m_font;
}
