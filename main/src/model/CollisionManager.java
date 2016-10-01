/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import model.dishobjects.DishObject;
import model.dishobjects.SpriteModel;

/**
 * Менеджер коллизий объектов
 */
public abstract class CollisionManager {
    
    /**
     * Словарь моделей спрайтов и соответствующих им объектов
     */
    private Map <SpriteModel, DishObject> objectMap = new HashMap <SpriteModel, DishObject>();
    
    /**
     * Обработка коллизии моделей спрайтов двух объектов
     * @param first модель спрайта первого объекта
     * @param second модель спрайта второго объекта
     */
    protected void collided(SpriteModel first, SpriteModel second) {
        DishObject firstObj = getObject(first);
        DishObject secondObj = getObject(second);
        collided(firstObj, secondObj);
    }
    
    /**
     * Обработка коллизии двух объектов
     * @param first первый объект
     * @param second второй объект
     */
    protected void collided(DishObject first, DishObject second) {
        // Если объекты ранее были удалены
        if (first == null || second == null)
            return;
        
        // Осуществить коллизию первого объекта со вторым
        first.collide(second);
        
        // Если второй объект не исчез с поля в результате коллизии, 
        // то осуществить коллизию второго объекта с первым
        if (Dish.instance.objectExists(second)) {
            second.collide(first);
        }
    }
    
    /**
     * Добавить объект в менеджер коллизий
     * @param obj добавляемый объект
     */
    public void addObject(DishObject obj) {
        // Занести в словарь
        objectMap.put(obj.getSpriteModel(), obj);
    }
    
    /**
     * Удалить объект из менеджера коллизий
     * @param obj удаляемый объект
     */
    public void removeObject(DishObject obj) {
        // Удалить из словаря
        for (Entry <SpriteModel, DishObject> cur : objectMap.entrySet()) {
            if (cur.getValue() == obj) {
                objectMap.remove(cur.getKey());
                break;
            }
        }
    }
    
    /**
     * Получить объект по модели его спрайта
     * @param spriteModel модель спрайта объекта
     * @return объект, которому принадлежит переданная модель спрайта
     */
    private DishObject getObject(SpriteModel spriteModel) {
        return objectMap.get(spriteModel);
    }
    
    public abstract void checkCollision();
}
