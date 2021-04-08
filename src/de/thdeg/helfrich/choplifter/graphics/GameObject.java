package de.thdeg.helfrich.choplifter.graphics;

import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

/**
 * Represents GameObjects in the game.
 */
public class GameObject {
    /**
     * Makes a connection to GameView.
     */
    public GameView gameView;
    /**
     * Makes a connection to position.
     */
    public Position position;
    /**
     * Defines the speed of GameObjects.
     */
    protected double speedInPixel;
    /**
     * Defines the size of GameObjects.
     */
    protected double size;
    /**
     * Defines the degree of the rotation of GameObjects.
     */
    protected double rotation;
    /**
     * Defines the width of a GameObject.
     */
    protected int width;
    /**
     * Defines the height of a Game Object.
     */
    protected int height;

    private int numberOfGameObjects;
    private String gameObjectName;

    /**
     * Creates a new GameObject.
     *
     * @param gameView GameView to show the GameObject on.
     */
    public GameObject(GameView gameView) {
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
    public void updatePosition() {
    }

    /**
     * Draws the GameObject to the canvas.
     */
    public void addToCanvas() {
    }

    private void countGameObjects(){

    }

    @Override
    public String toString () {
        return "GameObject: (" + "position=" + position + ")";
    }
}

