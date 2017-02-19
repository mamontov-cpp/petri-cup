package engine;

import java.awt.Font;

/**
 * Систесный шрифт для отрисовки надписей
 */
public class SystemFont extends com.golden.gamedev.object.font.SystemFont {
    
    /**
     * Создает новый системный шрифт
     * @param fontName имя
     * @param attrs атрибуты
     * @param size размер шрифта
     * @param clr  цвет
     */
    public SystemFont(String fontName, int attrs, int size, java.awt.Color clr) {
        super(new Font(fontName, attrs, size), clr);
    }
    
    /**
     * Рисует строку с заданным значением строки
     * @param g контекст
     * @param data данные
     * @param x координата X
     * @param y координата Y
     */
    public void drawString(Graphics2D g, String data, int x, int y) {
        super.drawString(g.get(), data, x, y);
    }
}
