package engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Группа спрайтов
 */
public class SpriteGroup {
    /**
     * Создает новую именованную группу спрайтов
     * @param string 
     */
    public SpriteGroup(String string) {
        m_name = string;
        m_list = new ArrayList<>();
    }
    
    /**
     * Добавляет новый спрайт в группу
     * @param s 
     */
    public void add(Sprite s) {
        m_list.add(s);
    }
    
    /**
     * Удаляет группу из спрайтов
     * @param s 
     */
    public void remove(Sprite s) {
        m_list.remove(s);
    }
    
    /**
     * Устанавливает фон для группы спрайтов
     * @param bg 
     */
    public void setBackground(ImageBackground bg) {
        
    }
    
    /**
     * Обновляет состояние группы спрайтов
     * @param elapsed 
     */
    public void update(long elapsed) {
        m_list.stream().forEach((s) -> {
            s.update(elapsed);
        });
    }
    
    /**
     * Рендерит группу в контексте
     * @param g 
     */
    public void render(Graphics2D g) {
        m_list.stream().forEach((s) -> {
            s.render(g);
        });
    }
    
    /**
     * Возвращает список из всех спрайтов
     * @return 
     */
    public List<Sprite> toList() {
        return m_list;
    }
    
    /**
     * Имя спрайта
     */
    String m_name;
    
    /**
     * Список спрайтов
     */
    ArrayList<Sprite> m_list;
}
