/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специализация "Растение-хищник"
 */
public class PredatorPlant extends Specialization {
    
    public PredatorPlant() {
        super("Predator plant", 999999);
        
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, Oxygen.class).addRule(CarbonDioxyde.class)
                                                                     .addRule(Light.class)
                                                                     .addRule(Water.class));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(PrimitiveAnimal.class, 1, 0.5));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(PhytophagousAnimal.class, 1, 0.5));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(BacteriumBuffalo.class, 1, 0.5));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(PredatorAnimal.class, 1, 0.5));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(PhytophagousAnimal.class, 1, 0.5));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(OmnivoreAnimal.class, 1, 0.5));
    }
}
