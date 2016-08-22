/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специализация "Всеядное животное"
 */
class OmnivoreAnimal extends Specialization {
    
    public OmnivoreAnimal() {
        super("Omnivore animal", 999999);
        
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
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(PrimitiveAnimal.class, 1, 2));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(PhytophagousAnimal.class, 1, 2));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(BacteriumBuffalo.class, 1, 2));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(PredatorAnimal.class, 1, 2));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(BacteriumTiger.class, 1, 2));
    }
}
