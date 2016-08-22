/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специализация "Первичная бактерия"
 */
public class InitialBacterium extends Specialization {

    public InitialBacterium() {
        super("Initial bacterium", 100);
        
        addRation(new Ration(Ration.HIGH_EFFICIENCY, CarbonDioxyde.class).addRule(Agar.class)
                                                                         .addRule(Water.class)
                                                                         .addRule(Light.class));
        addRation(new Ration(Ration.HIGH_EFFICIENCY, CarbonDioxyde.class).addRule(InitialBacterium.class));
    }
}