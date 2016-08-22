/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import Listeners.DishObjectRemovedListener;
import view.dishobjects.DishObjectView;
import Listeners.DishObjectViewCreatedListener;
import com.golden.gamedev.object.Background;
import lml.FactoryGiver;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import model.Dish;
import model.dishobjects.DishObject;
import model.dishobjects.alive.Bacterium;
import view.dishobjects.BacteriumView;

/**
 * Представление поля
 */
public abstract class DishView implements DishObjectViewCreatedListener, DishObjectRemovedListener {
    
    public DishView() {
        // Подписаться на сигналы о создании представлений объектов
        FactoryGiver.getFactory().getViewFactory().addDishObjectViewCreatedListener(this);
        
        // Подписаться на сигналы об удалении объектов
        Dish.instance.addDishObjectRemovedListener(this);
    }
    
    /**
     * Представления объектов на поле
     */
    protected List <DishObjectView> objectViews = new ArrayList <DishObjectView>();
    
    /**
     * Фон чашки петри
     */
    protected Background bg;
    
    /**
     * Бактерия игрока для центровки
     */
    protected Bacterium player;
    
    /**
     * Добавление нового представления
     * @param view новое представление
     */
    private void addView(DishObjectView view) {
        if (view instanceof BacteriumView && player == null)
            player = (Bacterium) view.getDishObject();
        objectViews.add(view);
    }
    
    /**
     * Удаление представления
     * @param view удаляемое представление
     */
    private void removeView(DishObjectView view) {
        objectViews.remove(view);
    }
    
    public void render(Graphics2D gd) {
        repaint(gd);
        for (DishObjectView view : objectViews)
            view.render(gd);
    }
    
    /**
     * Отрисовка непосредственно поля
     */
    protected abstract void repaint(Graphics2D gd);
    
    /**
     * Получить координаты фона
     * @return координаты фона
     */
    public Point getBackgroundCoordinates() {
        return new Point((int)bg.getX(), (int)bg.getY());
    }
    
    @Override
    public void dishObjectViewCreated(DishObjectView view) {
        addView(view);
    }
    
    @Override
    public void dishObjectRemoved(DishObject obj) {
        for (DishObjectView view : objectViews) {
            if (view.getDishObject() == obj) {
                removeView(view);
                break;
            }
        }
    }
}
