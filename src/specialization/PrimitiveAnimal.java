/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специаоизация "Примитивное животное"
 */
class PrimitiveAnimal extends Specialization {
    
    public PrimitiveAnimal() {
        super("Primitive animal", 150);
        
        addRation(new Ration(Ration.AVARAGE_EFFICIENCY, CarbonDioxyde.class).addRule(Oxygen.class)
                                                                            .addRule(Water.class)
                                                                            .addRule(InitialBacterium.class, 1, 1.2));
    }
}
