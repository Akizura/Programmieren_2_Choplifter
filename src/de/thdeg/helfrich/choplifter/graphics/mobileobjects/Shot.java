package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;

/**
 * This class manages the shots of the jets, tanks and the chopper.
 */
public abstract class Shot extends GameObject {

    protected Shot(GameView gameView){
        super(gameView);
    }
}
