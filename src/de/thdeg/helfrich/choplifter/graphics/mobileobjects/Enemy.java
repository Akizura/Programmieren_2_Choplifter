package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents the Enemies in the game.
 */
abstract class Enemy extends CollidingGameObject {

    protected boolean inRangeOfChopper;

    protected Enemy(GameView gameView, ArrayList<CollidableGameObject> objectsToCollideWith) {
        super(gameView, objectsToCollideWith);
        this.inRangeOfChopper = false;
    }
    @Override
    public Enemy clone() {
        return (Enemy) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Enemy enemy = (Enemy) o;
        return inRangeOfChopper == enemy.inRangeOfChopper;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inRangeOfChopper);
    }
}
