package de.thdeg.helfrich.choplifter.graphics.basics;

import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

/**
 * Represents all game objects that are able to collide with something.
 */
public abstract class CollidableGameObject extends GameObject{

    protected Rectangle hitBox;

    protected CollidableGameObject (GameView gameView){
        super(gameView);
        this.hitBox = new Rectangle(-100000, -1000000, 0, 0);
    }

    @Override
    public void update() {
        super.update();
        updateHitBoxPosition();
    }

    /**
     * Used to update the position of the hitBox in the game.
     */
    protected abstract void updateHitBoxPosition();

    /**
     * If a game object has collided with something, it is able to react to the collision.
     * @param otherObject The other gameObject that is involved in the collsion.
     */
    protected abstract  void reactToCollision(CollidableGameObject otherObject);

}
