package engine;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Менеджер текстур
 */
public class TextureManager {
    
    /**
     * Сущность для менеджера
     */
    static class Entry {
        Texture m_texture;
        BufferedImage m_image;
    }
    
    /**
     * Преборазует изображение в текстуру
     * @param img
     * @return 
     */
    public static Texture imageToTexture(BufferedImage img) {
        Pixmap px = new Pixmap(img.getWidth(), img.getHeight(), Pixmap.Format.RGBA8888);
        Pixmap.setBlending(Pixmap.Blending.None);
        for(int i = 0; i < img.getWidth(); i++) {
            for(int j = 0; j < img.getHeight(); j++) {
                px.drawPixel(j, j, img.getRGB(i, j));
            }
        }
        return new Texture(px);
    }
    
    /**
     * Получает текстуру для изображения
     * @param img изображение
     * @return текстура
     */
    public static Texture getTexture(BufferedImage img) {
        if (m_entries == null) {
            m_entries = new ArrayList<>();
        }
        for (Entry m_entry : m_entries) {
            if (m_entry.m_image == img) {
                return m_entry.m_texture;
            }            
        }
        Texture tex = TextureManager.imageToTexture(img);
        Entry e = new Entry();
        e.m_image = img;
        e.m_texture = tex;
        m_entries.add(e);
        return e.m_texture;
    }
    
    
    public static void disposeTextures() {
        if (m_entries != null) {
            m_entries.stream().forEach((m_entry) -> {
                m_entry.m_texture.dispose();
            });            
        }
    }
    
    
    
    /**
     * Сущности
     */
    static List<Entry> m_entries;
}
