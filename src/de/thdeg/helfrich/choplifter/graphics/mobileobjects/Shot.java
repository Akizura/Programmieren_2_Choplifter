package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;

import java.util.ArrayList;

/**
 * This class manages the shots of the jets, tanks and the chopper.
 */
public abstract class Shot extends CollidingGameObject {

    protected Shot(GameView gameView, ArrayList<CollidableGameObject> objectsToCollideWith){
        super(gameView, objectsToCollideWith);
    }
}
