/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

/**
 * Правило поедания конкретного типа объекта
 */
public class RationRule {
    
    /**
     * Допустимое соотношение размеров
     */
    public double sizeRatio;

    /**
     * Необходимое количество объектов
     */
    public int count;

    public RationRule(int count, double sizeRatio) {
        this.count = count;
        this.sizeRatio = sizeRatio;
    }

    public RationRule(int count) {
        this(count, 1);
    }

    public RationRule() {
        this(1, 1);
    }
}
