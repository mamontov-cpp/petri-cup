/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dishobjects.alive;

import Listeners.DishObjectGrownListener;
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
     * Съеденные объекта
     */
    private List <DishObject> eaten = new ArrayList<DishObject>();
    
    /**
     * Количество съеденных объектов
     */
    private Integer eatenCount = 0;
    
    /**
     * Слушатели события роста массы
     */
    private List <DishObjectGrownListener> DOGListeners = new ArrayList <DishObjectGrownListener>();
        
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
        // Съесть
        eaten.add(obj);
        
        eatenCount += 1;
        
        // Удалить съеденный объект с поля
        Dish.instance.removeObject(obj);
        
        setMass(mass + 5);
        
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

}
