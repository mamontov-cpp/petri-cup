/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.util.List;
import model.dishobjects.alive.Bacterium;
import specialization.Specialization;

/**
 * Слушатель события запроса смены специализации
 */
public interface AskForSpecializationListener {
    /**
     * Запросить новую специализацию из доступных
     * @param availableUpgrades список доступных специализаций
     * @param obj бактерия, которой выбирается новая специализация
     */
    void askForSpecialization(List <Specialization> availableUpgrades, Bacterium obj);
}
