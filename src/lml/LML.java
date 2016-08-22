/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lml;

/**
 *
 * @author user
 */
public class LML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FactoryGiver.getFactory().getGame().start();
    }
}
