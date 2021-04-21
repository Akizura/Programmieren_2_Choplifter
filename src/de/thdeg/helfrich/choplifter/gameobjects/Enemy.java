package de.thdeg.helfrich.choplifter.gameobjects;

import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

/**
 * Represents the Enemies in the game.
 */
abstract class Enemy extends GameObject {

    protected boolean inRangeOfChopper;

    protected Enemy(GameView gameView){
        super(gameView);
        this.inRangeOfChopper = false;
    }
}
