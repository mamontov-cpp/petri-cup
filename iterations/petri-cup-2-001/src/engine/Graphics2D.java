package engine;

/**
 * Графический контекст для рисования
 */
public class Graphics2D {
    
    
    /**
     * Графика
     * @param g 
     */
    public Graphics2D(java.awt.Graphics2D g) {
        m_g = g;
    }
    
    
    /**
     * Возврщает реальный объект для рисования. Не переносить!
     * @return объект
     */
    public java.awt.Graphics2D get() {
        return m_g;
    } 
    
    
    java.awt.Graphics2D m_g;
}
