/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package specialization;

import Listeners.AskForSpecializationListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Дерево специализаций
 */
public class SpecializationTree {
    
    /**
     * Начальная специализация всех растущих объектов
     */
    private Specialization initial;
    
    /**
     * Дерево специализаций
     */
    private Map <Class, List <Specialization> > tree = new HashMap <Class, List <Specialization> >();
    
    public static SpecializationTree instance = new SpecializationTree();
    
    private SpecializationTree() {
        
        initial = new InitialBacterium();
        
        tree.put(InitialBacterium.class, new ArrayList <Specialization>());
        tree.put(PrimitivePlant.class, new ArrayList <Specialization>());
        tree.put(PrimitiveAnimal.class, new ArrayList <Specialization>());
        tree.put(BacteriumMoss.class, new ArrayList <Specialization>());
        tree.put(ParasitePlant.class, new ArrayList <Specialization>());
        tree.put(PredatorPlant.class, new ArrayList <Specialization>());
        tree.put(PhytophagousAnimal.class, new ArrayList <Specialization>());
        tree.put(PredatorAnimal.class, new ArrayList <Specialization>());
        tree.put(OmnivoreAnimal.class, new ArrayList <Specialization>());
        tree.put(BacteriumBuffalo.class, new ArrayList <Specialization>());
        tree.put(BacteriumTiger.class, new ArrayList <Specialization>());
        
        tree.get(InitialBacterium.class).add(new PrimitivePlant());
        tree.get(InitialBacterium.class).add(new PrimitiveAnimal());
        tree.get(PrimitivePlant.class).add(new BacteriumMoss());
        tree.get(PrimitivePlant.class).add(new ParasitePlant());
        tree.get(PrimitivePlant.class).add(new PredatorPlant());
        tree.get(PrimitiveAnimal.class).add(new PhytophagousAnimal());
        tree.get(PrimitiveAnimal.class).add(new PredatorAnimal());
        tree.get(PrimitiveAnimal.class).add(new OmnivoreAnimal());
        tree.get(PhytophagousAnimal.class).add(new BacteriumBuffalo());
        tree.get(PredatorAnimal.class).add(new BacteriumTiger());
    }
    
    /**
     * Получить доступные улучшения для специализации
     * @param spec специализация, для которой запрашиваются доступные улучшения
     * @return список доступных улучшений
     */
    public List <Specialization> upgrades(Class spec) {
        return tree.get(spec);
    }
    
    /**
     * Получить базовую специализацию
     * @return базовая специализация дерева специализаций
     */
    public Specialization getInitialSpecialization() {
        return initial;
    }
    
    /**
     * Установить слушателя запроса на смену специализации всем специализациям
     * @param l слушатель запроса на смену специализации
     */
    public void addAskForSpecializationListener(AskForSpecializationListener l) {
        Set <Class> classes = tree.keySet();
        
        initial.addAskForSpecializationListener(l);
        for (Class curClass : classes) {
            for (int i = 0; i < tree.get(curClass).size(); ++i) {
                tree.get(curClass).get(i).addAskForSpecializationListener(l);
            }
        }
    }
}