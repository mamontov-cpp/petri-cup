/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специальность "Растение-паразит"
 */
public class ParasitePlant extends Specialization {
    
    public ParasitePlant() {
        super("Parasite plant", 999999);
        
        addRation(new Ration(Ration.LOW_EFFICIENCY,  Oxygen.class).addRule(CarbonDioxyde.class)
                                                                  .addRule(Light.class)
                                                                  .addRule(Water.class));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(PrimitivePlant.class, 1, 1.5));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(BacteriumMoss.class, 1, 1.5));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(ParasitePlant.class, 1, 1.5));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(PredatorPlant.class, 1, 1.5));
    }
}
