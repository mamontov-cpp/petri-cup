/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специализация "Хищное животное"
 */
class PredatorAnimal extends Specialization {
    
    public PredatorAnimal() {
        super("Predator animal", 200);
        
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                            .addRule(Water.class)
                                                                            .addRule(PrimitiveAnimal.class, 1, 2));
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                            .addRule(Water.class)
                                                                            .addRule(PhytophagousAnimal.class, 1, 2));
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                            .addRule(Water.class)
                                                                            .addRule(BacteriumBuffalo.class, 1, 2));
    }
}
