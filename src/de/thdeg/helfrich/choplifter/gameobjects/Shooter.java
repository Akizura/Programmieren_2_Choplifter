package de.thdeg.helfrich.choplifter.gameobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;

/**
 * Represents the Shooters in the game.
 */
abstract class Shooter extends Enemy {

    protected double shotsPerSecond;

    protected Shooter(GameView gameView){
        super(gameView);
        this.shotsPerSecond = 5;
    }
}
