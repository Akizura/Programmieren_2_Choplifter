package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.Enemy;

/**
 * Represents the Shooters in the game.
 */
abstract class Shooter extends Enemy {

    protected double shotsPerSecond;

    protected Shooter(GameView gameView) {
        super(gameView);
        this.shotsPerSecond = 5;
    }
}
