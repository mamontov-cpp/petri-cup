/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import model.dishobjects.DishObject;
import model.dishobjects.alive.AliveObject;
import view.SizeConverter;

/**
 * Рацион, по которому осуществляется рост объектов
 */
public class Ration {
    
    /**
     * Коэффициент роста для при высокой эффективности рациона
     */
    public static double HIGH_EFFICIENCY = 1.0;
    
    /**
     * Коэффициент роста для при средней эффективности рациона
     */
    public static double AVARAGE_EFFICIENCY = 0.7;
    
    /**
     * Коэффициент роста для при низкой эффективности рациона
     */
    public static double LOW_EFFICIENCY = 0.4;
    
    /**
     * Масса элемента, требуемого на единицу роста
     */
    private final int MASS_PER_GROWTH = 20;
    
    /**
     * Масса элемента, требуемого на единицу продукта жизнедеятельности
     */
    private final int EATEN_MASS_PER_JUNK = 50;
    
    /**
     * Содержимое рациона, ключ - класс объекта, значение - законы съедения объектов данного типа
     */
    private Map <Class, RationRule> ration;
    
    /**
     * Эффективность роста при выполнении рациона
     */
    private double efficiency;
    
    /**
     * Результат жизнедеятельности при выполнении рациона
     */
    private Class junk;
    
    public Ration(double efficiency, Class junk) {
        this.efficiency = efficiency;
        this.junk = junk;
        this.ration = new HashMap <Class, RationRule>();
    }
    
    /**
     * Добавить правило в рацион
     * @param possibleClass класс допустимого объекта
     * @param count количество данного объекта, необходимое для выполнения рациона
     * @param sizeRatio коэффициент допустимого для съедения размера
     * @return текущий экземпляр класса для повторного добавления элементов
     */
    public Ration addRule(Class possibleClass, int count, double sizeRatio) {
        ration.put(possibleClass, new RationRule(count, sizeRatio));
        return this;
    }
    
    /**
     * Добавить правило в рацион
     * @param possibleClass класс допустимого объекта
     * @param count количество данного объекта, необходимое для выполнения рациона
     * @return текущий экземпляр класса для повторного добавления элементов
     */
    public Ration addRule(Class possibleClass, int count) {
        return addRule(possibleClass, count, 1);
    }
    
    /**
     * Добавить правило в рацион
     * @param possibleClass класс допустимого объекта
     * @return текущий экземпляр класса для повторного добавления элементов
     */
    public Ration addRule(Class possibleClass) {
        return addRule(possibleClass, 1, 1);
    }
    
    /**
     * Проверить допустимость съедения одного объекта другим
     * @param eaten съедаемый объект
     * @param eater съедающий объект
     * @return признак допустимости съедения
     */
    public boolean canEat(DishObject eaten, DishObject eater) {
        Class eatenClass = eaten.getClass();
        if (eaten instanceof AliveObject)
            eatenClass = ((AliveObject)eaten).getSpecialization().getClass();
        
        // Если съедаемый объект включен в текущий рацион и удовлетворяет правилам съедения, то его можно съесть
        if (ration.containsKey(eatenClass) && 
                SizeConverter.massToSize(eaten.getMass()) <= SizeConverter.massToSize(eater.getMass()) * ration.get(eatenClass).sizeRatio) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Проверить, выполняется ли текущий рацион при заданных съеденных объектах
     * @param eaten съеденные объекты, ключ - класс объекта, значение - количество съеденных объектов данного типа
     * @return признак выполнения рациона
     */
    public boolean rationCompleted(Map <Class, Integer> eaten) {
        Set <Class> possibleClasses = ration.keySet();
        // Проверить наличие нужного количества объектов всех необходимых классов
        for (Class curClass : possibleClasses) {
            if (!eaten.containsKey(curClass) || eaten.get(curClass) < ration.get(curClass).count)
                return false;
        }
        return true;
    }
    
    /**
     * Получить количество продуктов жизнедеятельности для выброса при выполнении рациона
     * @param eatenMass масса съеденных объектов по выполненному рациону
     * @return количество испускаемых продуктов жизнедеятельности
     */
    public int junkCount(int eatenMass) {
        return Math.max(eatenMass / EATEN_MASS_PER_JUNK, 1);
    }
    
    /**
     * Получить прирост массы для текущего рациона
     * @param eatenMass суммарная масса съеденных элементов, входящих в данный рацион
     * @return величина прироста массы
     */
    public int getMassGrowth(int eatenMass) {
        return (int) (eatenMass * efficiency / MASS_PER_GROWTH);
    }
    
    /**
     * Получить текущий рацион в виде тип-количество
     * @return текущий рацион в виде тип-количество
     */
    public Map <Class, Integer> getRation() {
        // Составить набор пар класс - количество объектов данного класса
        Map <Class, Integer> result = new HashMap <Class, Integer>();
        Set <Class> possibleClasses = ration.keySet();
        for (Class curClass : possibleClasses) {
            result.put(curClass, ration.get(curClass).count);
        }
        
        return result;
    }
    
    /**
     * Получить класс объекта, создающегося в результате выполнения рациона
     * @return класс объекта результата жизнедеятельности
     */
    public Class getJunkClass() {
        return junk;
    }
}
