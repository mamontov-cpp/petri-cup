/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects.alive;

import Listeners.DishObjectGrownListener;
import Listeners.SpecializationChangedListener;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import lml.FactoryGiver;
import lml.GameMath;
import model.Dish;
import model.dishobjects.DishObject;
import model.dishobjects.SpriteModel;
import specialization.Ration;
import specialization.Specialization;

/**
 * Движущийся (живой) объект
 */
public abstract class AliveObject extends DishObject {

    /**
     * Минимальное расстояние до точки назначения, необходимое для начала движения
     */
    protected final int MIN_MOVE_DISTANCE = 10;
    
    /**
     * Точка, до которой движется бактерия
     */
    protected Point destination;
    
    /**
     * Специализация объекта
     */
    private Specialization specialization;
    
    /**
     * Съеденные объекта
     */
    private List <DishObject> eaten = new ArrayList<DishObject>();
    
    /**
     * Количество съеденных объектов каждого типа
     */
    private Map <Class, Integer> eatenCount = new HashMap <Class, Integer>();
    
    /**
     * Слушатели события роста массы
     */
    private List <DishObjectGrownListener> DOGListeners = new ArrayList <DishObjectGrownListener>();
    
    /**
     * Слушатели события изменения специализации
     */
    private List <SpecializationChangedListener> SCListeners = new ArrayList <SpecializationChangedListener>();
    
    public AliveObject(SpriteModel spriteModel) {
        super(spriteModel);
    }
    
    @Override
    public void update(long l) {
        if (destination != null) {
            // Если расстояние между точкой назначения и текущей координатой меньше 
            // минимального для движения, остановиться
            if (GameMath.distance(getPosition().x, getPosition().y, destination.x, destination.y) < MIN_MOVE_DISTANCE)
                this.energy = 0;
            // Иначе задать направление перемещения
            else
                setDirection(GameMath.angle(getPosition(), destination));
        }
        
        super.update(l);
    }

    @Override
    public void collide(DishObject obj) {
        eat(obj);
    }
    
    /**
     * Поглощение своего болида
     * @param bolid болид, который необходимо поглотить
     */
    protected void absorb(Bolid bolid) {
        // Увеличить массу бактерии на массу болида
        setMass(this.mass + bolid.getMass());
        
        // Удалить съеденный объект с поля
        Dish.instance.removeObject(bolid);
    }
    
    /**
     * Поедание объекта
     * @param obj поедаемый объект
     * @return признак успешного поедания
     */
    private boolean eat(DishObject obj) {
        if (!specialization.canEat(obj, this)) {
            return false;
        }
        
        // Съесть
        eaten.add(obj);
        
        Class objectClass = obj.getClass();
        if (obj instanceof AliveObject)
            objectClass = ((AliveObject)obj).getSpecialization().getClass();
        if (eatenCount.containsKey(objectClass))
            eatenCount.put(objectClass, eatenCount.get(objectClass) + 1);
        else
            eatenCount.put(objectClass, 1);
        
        // Удалить съеденный объект с поля
        Dish.instance.removeObject(obj);
        
        // Проверить выполнение рациона
        Ration completedRation = specialization.completedRation(eatenCount);
                
        // Если выполнился какой-то рацион
        if (completedRation != null) {
            int eatenMass = 0;          // суммарная масса съеденных объектов, входящих в выполненный рацион
            
            // Удалить из массива съеденных объектов объекты рациона
            Map <Class, Integer> objects = completedRation.getRation();
            Set <Class> classes = objects.keySet();
            for (Class curClass : classes) {
                for (int i = 0; i < eaten.size(); ++i) {
                    objectClass = eaten.get(i).getClass();
                    if (eaten.get(i) instanceof AliveObject)
                        objectClass = ((AliveObject)eaten.get(i)).getSpecialization().getClass();
                    // Если найден съеденный объект нужного типа
                    if (objectClass == curClass) {
                        // Увеличить суммарную массу съеденных объектов текущего рациона на массу текущего элемента
                        eatenMass += eaten.get(i).getMass();
                        
                        // Сократить количество съеденных объектов данного 
                        eatenCount.put(curClass, eatenCount.get(curClass) - 1);
                        
                        // Удалить его из съеденных объектов
                        eaten.remove(i);
                        i--;
                        
                        // Уменьшить количество оставшихся востребованных объектов данного типа
                        objects.put(curClass, objects.get(curClass) - 1);
                        
                        // Если набрано нужное количетсво объектов текущего типа - перейти к следующему
                        if (objects.get(curClass) == 0) {
                            break;
                        }
                    }
                }
            }
            
            // Увеличить массу объекта
            setMass(mass + completedRation.getMassGrowth(eatenMass));
            
            // Получить количество испускаемых продуктов жизнедеятельности при выполнении текущего рациона
            int junkCount = completedRation.junkCount(eatenMass);
            
            // Испустить продукты жизнедеятельности
            for (int i = 0; i < junkCount; ++i) {
                throwJunk(completedRation.getJunkClass());
            }
        }
        
        return true;
    }
    
    /**
     * Изменение массы объекта
     * @param newMass новая масса
     */
    protected void setMass(int newMass) {
        mass = newMass;
        
        // Оповестить слушателей об изменении размеров
        fireDishObjectGrown();
    }
    
    /**
     * Установить точку цели движения бактерии
     * @param dest точка, до которой будет двигаться бактерия
     */
    public void setDestination(Point dest) {
        destination = dest;
        setDirection(GameMath.angle(getPosition(), dest));
    }
    
    /**
     * Выплёвывание болида
     */
    public void throwJunk(Class junkClass) {
        // Испустить результат жизнедеятельности в случайном направлении
        Random rand = new Random();
        FactoryGiver.getFactory().getPrimitiveObjectFactory().createPrimitiveObject(junkClass, getPosition()).setDirection(rand.nextInt(360));
    }
    
    /**
     * Установить специализацию объекта
     * @param spec устанавливаемая специализация
     */
    public void setSpecialization(Specialization spec) {
        // Проверить возможность улучшения до заданной специализации из текущей
        if (specialization != null && !specialization.availableUpgrades().contains(spec))
            return;
        
        // Улучшить специализацию
        if (specialization != null)
            DOGListeners.remove(specialization);
        specialization = spec;
        addDishObjectGrownListener(spec);
        
        // Сообщить об изменении специализации
        fireSpecializationChanged();
    }
    
    /**
     * Получение специализации объекта
     * @return специализация объекта
     */
    public Specialization getSpecialization() {
        return specialization;
    }
    
    /**
     * Добавить слушателя события роста массы объекта
     */
    public void addDishObjectGrownListener(DishObjectGrownListener listener) {
        DOGListeners.add(listener);
    }
    
    /**
     * Сообщить о росте массы объекта
     */
    private void fireDishObjectGrown() {
        for (int i = 0; i < DOGListeners.size(); ++i)
            DOGListeners.get(i).growed(this);
    }
    
    /**
     * Добавить слушателя события изменения специализации объекта
     */
    public void addSpecializationChangedListener(SpecializationChangedListener listener) {
        SCListeners.add(listener);
    }
    
    /**
     * Сообщить об изменении специализации объекта
     */
    private void fireSpecializationChanged() {
        for (int i = 0; i < SCListeners.size(); ++i)
            SCListeners.get(i).specializationChanged();
    }
}
