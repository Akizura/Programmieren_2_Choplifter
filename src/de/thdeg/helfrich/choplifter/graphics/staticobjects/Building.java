package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;

abstract class Building extends CollidableGameObject {

    Building(GameView gameView) {
        super(gameView);
    }
}
