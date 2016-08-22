/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специализация "Бактерия-буйвол"
 */
class BacteriumBuffalo extends Specialization {
    
    public BacteriumBuffalo() {
        super("Bacterium buffalo", 999999);
        
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(PrimitivePlant.class, 1, 1.25));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(BacteriumMoss.class, 1, 1.25));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(ParasitePlant.class, 1, 1.25));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(PredatorPlant.class, 1, 1.25));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                         .addRule(Water.class)
                                                                         .addRule(BacteriumMoss.class, 1, 1.5));
    }
}
