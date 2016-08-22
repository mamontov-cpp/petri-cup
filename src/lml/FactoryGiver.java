/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lml;

import gtge.GTGEFactory;

/**
 * Возвращает единственный экземпляр фабрики
 */
public class FactoryGiver {
    private static Factory factory = new GTGEFactory();
    
    private FactoryGiver() {
        
    }
    
    public static Factory getFactory() {
        return factory;
    }
}
