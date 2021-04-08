package de.thdeg.helfrich.choplifter.game;

/**
 * Manages the whole game.
 */
public class Start {
    public static void main(String[] args) {
        GameLoopManager gameLoopManager= new GameLoopManager();
        gameLoopManager.startGame();
    }
}
