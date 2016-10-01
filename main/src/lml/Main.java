/*
 * Игра в стиле agar.io для одного игрока.
 *
 * В данном файле содержится стартовый класс
 */

package lml;

/**
 * Стартовый класс программы
 */
public class Main {

    /**
     * Запускает игру
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        FactoryGiver.getFactory().getGame().start();
    }
}
