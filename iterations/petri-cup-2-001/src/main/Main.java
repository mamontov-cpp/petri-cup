package main;

import engine.GameLoader;
import game.Game;

/**
 * Main class
 */
public class Main {
    /**
     * Runs a game
     * @param args arguments 
     */
    public static void main(String[] args) {
        Game game = new Game();
        GameLoader loader = new GameLoader();
        loader.setup(game, game.dimensions(), false);
        loader.start();
    }
}
