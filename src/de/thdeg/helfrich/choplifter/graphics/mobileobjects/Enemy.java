package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;

/**
 * Represents the Enemies in the game.
 */
abstract class Enemy extends CollidableGameObject {

    protected boolean inRangeOfChopper;

    protected Enemy(GameView gameView) {
        super(gameView);
        this.inRangeOfChopper = false;
    }
}
