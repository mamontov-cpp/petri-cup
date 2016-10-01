package game.images;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Max Satu
 */
public class Agar {
    
    /**
     * Возвращает изображение
     * @return изображение
     */
    public static BufferedImage image()
    {
        if (image == null)
        {
            image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);

            Color color = new Color(220, 220, 220);
            Graphics2D g2d = image.createGraphics();               
            g2d.setColor(color);
            g2d.fillOval(0, 0, size, size);
            
            // Обозначить периметр
            g2d.setColor(color.darker().darker());
            g2d.setStroke(new BasicStroke(2));
            g2d.drawOval(0, 0, size, size);           
        }
        return image;
    }
    /**
     * Кэшированное изображение
     */
    private static BufferedImage image = null;
    /**
     * Размер агара
     */
    private static final int size = 20;
}
