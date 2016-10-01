/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import Listeners.DishObjectRemovedListener;
import lml.GameMath;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lml.FactoryGiver;
import model.dishobjects.DishObject;
import view.SizeConverter;

/**
 * Чашка Петри
 */
public class Dish {
    
    /**
     * Количество попыток, предпринимаемых для успешного размещения объекта на свободной позиции на поле
     */
    private final int OBJECT_ADD_ATTEMPTS_COUNT = 20;
    
    /**
     * Размеры поля
     */    
    public static int fieldWidth = 3000,
            fieldHeight = 1985;
    
    /**
     * Единственный экземпляр чашки Петри
     */
    public static Dish instance = new Dish();
    
    private Dish() {
        
    }
    
    /**
     * Объекты на чашке
     */
    private List <DishObject> objects = new ArrayList <DishObject>();
    
    /**
     * Слушатели события удаления объекта
     */
    private List <DishObjectRemovedListener> DRListeners = new ArrayList <DishObjectRemovedListener>();
    
    /**
     * Добавить объект на чашку Петри
     * @param obj добавляемый объект
     * @param position позиция на чашке Петри
     */
    public void addObject(DishObject obj, Point position) {
        obj.setPosition(position);
        objects.add(obj);
        FactoryGiver.getFactory().getCollisionManager().addObject(obj);
    }
    
    /**
     * Добавить объект на чашку Петри в случайную позицию
     * @param obj добавляемый объект
     * @return признак успешного добавления
     */
    public boolean addObject(DishObject obj) {
        // Предпринять некоторое количество попыток разместить объект
        Random rand = new Random();
        for (int i = 0; i < OBJECT_ADD_ATTEMPTS_COUNT; ++i) {
            // Сгенерировать случайные координаты для объекта
            Point position = new Point(rand.nextInt(fieldWidth), rand.nextInt(fieldHeight));
            // Попытаться добавить объект по данным координатам
            if (isFreePosition(position, obj)) {
                addObject(obj, position);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Удалить объект с поля
     * @param obj удаляемый объект
     */
    public void removeObject(DishObject obj) {
        // Удалить из списка объектов
        objects.remove(obj);
        
        // Удалить из менеджера коллизий
        FactoryGiver.getFactory().getCollisionManager().removeObject(obj);
        
        // Сообщить об удалении
        fireDishObjectRemoved(obj);
    }
    
    /**
     * Получить объекты на поле
     * @return объекты на поле
     */
    public List <DishObject> getObjects() {
        return objects;
    }
    
    /**
     * Проверить, есть ли объект на поле
     * @param obj искомый объект
     * @return признак наличия объекта на поле
     */
    public boolean objectExists(DishObject obj) {
        return objects.contains(obj);
    }
    
    /**
     * Проверить, можно ли в заданной позиции разместить заданный объект без пересечений с остальными
     * @param position позиция, в которую нужно разместить объект
     * @param obj добавляемый объект
     * @return доступность позиции для размещения объекта
     */
    private boolean isFreePosition(Point position, DishObject obj) {
        int x1 = (int) position.getX(), y1 = (int) position.getY();
        
        // Проверить выход за границы поля
        int objSize = SizeConverter.massToSize(obj.getMass());
        if (x1 - objSize / 2.0 < 0 || x1 + objSize / 2.0 >= fieldWidth ||
                y1 - objSize / 2.0 < 0 || y1 + objSize / 2.0 >= fieldHeight)
            return false;
        
        for (DishObject curObj : objects) {
            // Координаты центра текущего объекта
            int x2 = (int) curObj.getPosition().getX(), y2 = (int) curObj.getPosition().getY();
            
            // Подсчёт расстояния между центрами центрами объектов по теореме Пифагора
            double distance = GameMath.distance(x1, y1, x2, y2);
            
            // Проверка наложения
            int curObjSize = SizeConverter.massToSize(curObj.getMass());
            if (distance <= (objSize + curObjSize) / 2.0)
                return false;
        }
        return true;
    }
    
    /**
     * Добавить слушателя события удаления объекта
     * @param listener слушатель события удаления объекта
     */
    public void addDishObjectRemovedListener(DishObjectRemovedListener listener) {
        DRListeners.add(listener);
    }
    
    /**
     * Сообщить об удалении объекта
     * @param obj удаляемый объект
     */
    private void fireDishObjectRemoved(DishObject obj) {
        for (DishObjectRemovedListener listener : DRListeners)
            listener.dishObjectRemoved(obj);
    }
}
