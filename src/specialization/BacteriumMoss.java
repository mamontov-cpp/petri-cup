/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import model.dishobjects.primitive.*;

/**
 * Специализация "Бактерия-мох"
 */
public class BacteriumMoss extends Specialization {
    
    public BacteriumMoss() {
        super("Bacterium moss", 999999);
        
        addRation(new Ration(Ration.HIGH_EFFICIENCY, Oxygen.class).addRule(CarbonDioxyde.class)
                                                                  .addRule(Light.class)
                                                                  .addRule(Water.class));
    }
}
