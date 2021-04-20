package de.thdeg.helfrich.choplifter.gameobjects;

import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

/**
 * Represents GameObjects in the game.
 */
abstract class GameObject {

    protected GameView gameView;
    protected Position position;
    protected double speedInPixel;
    protected double size;
    protected double rotation;
    protected int width;
    protected int height;

    protected int numberOfGameObjects;
    protected String gameObjectName;

    /**
     * Creates a new GameObject.
     *
     * @param gameView GameView to show the GameObject on.
     */
    protected GameObject(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(0, 0);
    }

    /**
     * Gets the current position of the GameObject, consisting of x- and y coordinates {@link Position}.
     *
     * @return Current position
     * @see Position
     */
    public Position getPosition(){ return this.position;}

    /**
     * Sets the position of the GameObject, consisting of x- and y coordinates {@link Position}.
     *
     * @param position The user is able to enter a new position for the GameObject.
     * @see Position
     */
    public void setPosition(Position position) { this.position = position; }

    /**
     * Updates the position of the GameObject.
     */
    public abstract void updatePosition();

    /**
     * Draws the GameObject to the canvas.
     */
    public abstract void addToCanvas();

    /**
     *Counts the GameObjects.
     */
    public void countGameObjects(){

    }

    @Override
    public String toString () {
        return "GameObject: (" + "position=" + position + ")";
    }
}

