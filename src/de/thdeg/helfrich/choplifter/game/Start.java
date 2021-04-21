package de.thdeg.helfrich.choplifter.game;

import de.thdeg.helfrich.choplifter.game.managers.GameLoopManager;

/**
 * Manages the whole game.
 */
public class Start {
    public static void main(String[] args) {
        GameLoopManager gameLoopManager= new GameLoopManager();
        gameLoopManager.startGame();
    }
}
