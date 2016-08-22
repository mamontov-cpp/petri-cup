/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специализация "Примитивное растение"
 */
public class PrimitivePlant extends Specialization {
    
    public PrimitivePlant() {
        super("Primitive Plant", 150);
        
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, Oxygen.class).addRule(CarbonDioxyde.class)
                                                                     .addRule(Light.class)
                                                                     .addRule(Water.class));
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, Oxygen.class).addRule(InitialBacterium.class));
    }
}
