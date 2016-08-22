/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package specialization;

import Listeners.AskForSpecializationListener;
import Listeners.DishObjectGrownListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dishobjects.DishObject;
import model.dishobjects.alive.AliveObject;
import model.dishobjects.alive.Bacterium;

/**
 * Специализация объекта
 */
public class Specialization  implements DishObjectGrownListener {
    
    /**
     * Рационы, относящиеся к текущей специализации
     */
    ArrayList <Ration> rations = new ArrayList <Ration>();
    
    /**
     * Название специализации
     */
    private final String name;
    
    /**
     * Масса объекта, при которой можно улучшать текущую специализацию
     */
    private final int upgradeMass;
        
    /**
     * Слушатели запроса на изменение специализации
     */
    private ArrayList<AskForSpecializationListener> AFSlisteners = new ArrayList<AskForSpecializationListener>();
    
    protected Specialization(String name, int upgradeMass) {        
        this.name = name;
        this.upgradeMass = upgradeMass;
    }
    
    /**
     * Получить название специализцаии
     * @return название специализации
     */
    public String getName() {
        return name;
    }
    
    /**
     * Добавить рацион к текущей специализации
     * @param ration добавляемый рацион
     * @return текущий экземпляр класса для повторного добавления элементов
     */
    public Specialization addRation(Ration ration) {
        rations.add(ration);
        return this;
    }
    
    /**
     * Проверить допустимость съедения одного объекта другим
     * @param eaten съедаемый объект
     * @param eater съедающий объект
     * @return признак допустимости съедения
     */
    public boolean canEat(DishObject eaten, DishObject eater) {
        // Если объект можно съесть в каком-нибудь из доступных рационов, то его можно есть
        for (Ration ration : rations) {
            if (ration.canEat(eaten, eater)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Получить выполненный рацион
     * @param eaten количество съеденных объектов каждого типа
     * @return выполненный рацион или null, если ни один не выполнен
     */
    public Ration completedRation(Map <Class, Integer> eaten) {
        // Проверить выполнение какого-нибудь рациона
        for (Ration ration : rations) {
            if (ration.rationCompleted(eaten)) {
                return ration;
            }
        }
        
        return null;
    }
    
    /**
     * Получить доступные улучшения специализации
     * @return доступные улучшения специализации
     */
    public List <Specialization> availableUpgrades() {
        return SpecializationTree.instance.upgrades(this.getClass());
    }

    @Override
    public void growed(AliveObject aliveObject) {
        if (aliveObject instanceof Bacterium && aliveObject.getMass() >= upgradeMass)
            fireAskForSpecialization(SpecializationTree.instance.upgrades(this.getClass()), (Bacterium)aliveObject);
    }
    
    /**
     * Добавить слушателя запроса на изменение специализации
     * @param l слушатель объекта
     */
    public void addAskForSpecializationListener(AskForSpecializationListener l) {
        AFSlisteners.add(l); 
    }

    /**
     * Оповестить слушателей о запросе на изменение специализации
     * @param availableUpgrades список доступных специализаций
     * @param obj объект, для которого запрашивается специализация
     */
    protected void fireAskForSpecialization(List <Specialization> availableUpgrades, Bacterium obj) {
        for (AskForSpecializationListener AFSlistener : AFSlisteners) {
            AFSlistener.askForSpecialization(availableUpgrades, obj);
        }
    }
}
