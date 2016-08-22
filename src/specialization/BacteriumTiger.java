/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package specialization;

import model.dishobjects.primitive.*;

/**
 * Специализация "Бактерия-Тигр"
 */
public class BacteriumTiger extends Specialization {
    
    public BacteriumTiger() {
        super("Bacterium tiger", 999999);
        
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(PrimitiveAnimal.class, 1, 2));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(PhytophagousAnimal.class, 1, 2));
        addRation(new Ration(Ration.LOW_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                        .addRule(Water.class)
                                                                        .addRule(BacteriumBuffalo.class, 1, 2));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                         .addRule(Water.class)
                                                                         .addRule(BacteriumBuffalo.class, 1, 1.5));
    }
}
