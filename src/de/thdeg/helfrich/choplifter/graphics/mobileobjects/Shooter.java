package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.Enemy;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents the Shooters in the game.
 */
abstract class Shooter extends Enemy {

    protected double shotsPerSecond;

    protected Shooter(GameView gameView, ArrayList<CollidableGameObject> objectsToCollideWith) {
        super(gameView, objectsToCollideWith);
        this.shotsPerSecond = 5;
    }
    @Override
    public Shooter clone() {
        return (Shooter) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shooter shooter= (Shooter) o;
        return shotsPerSecond == shooter.shotsPerSecond;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shotsPerSecond);
    }
}
