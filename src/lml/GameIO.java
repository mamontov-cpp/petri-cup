/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lml;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;
import specialization.Specialization;

/**
 * Интерфейс входных-выходных данных игры
 */
public interface GameIO {
    /**
     * Запрашивает специализацию из предложенных у пользователя
     * @param specializations список доступных специализаций
     * @return выбранную специализацию
     */
    public Specialization askForSpecialization(List <Specialization> specializations);
    
    /**
     * Возвращает позицию мыши на экране
     * @return координаты мыши на поле
     */
    public Point getMousePosition();
    
    /**
     * Загрузка изображения по указанному пути
     * @param path путь до изображения
     * @return загруженное значение
     */
    public BufferedImage getImage(String path);
    
    /**
     * Возвращает признак наличия запроса на плевок болида
     * @return признак наличия запроса на плевок болида
     */
    public boolean isBolidThrowingAsked();
}
