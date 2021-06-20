package de.thdeg.helfrich.choplifter.game.bin;

import de.thdeg.helfrich.choplifter.game.managers.GameLoopManager;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Manages the whole game.
 */
public class Start {
    public static void main(String[] args) {
        GameLoopManager gameLoopManager= new GameLoopManager();
        gameLoopManager.startGame();
    }
}
