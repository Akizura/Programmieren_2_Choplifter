package de.thdeg.helfrich.choplifter.graphics.basics;

import de.thdeg.helfrich.choplifter.game.managers.GameObjectManager;
import de.thdeg.helfrich.choplifter.game.managers.GamePlayManager;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.util.Objects;

/**
 * Represents GameObjects in the game.
 */
public abstract class GameObject implements Cloneable{

    protected GameView gameView;
    protected GamePlayManager gamePlayManager;
    protected GameObjectManager gameObjectManager;
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
    public Position getPosition() {
        return this.position;
    }

    /**
     * Sets the position of the GameObject, consisting of x- and y coordinates {@link Position}.
     *
     * @param position The user is able to enter a new position for the GameObject.
     * @see Position
     */
    public void setPosition(Position position) {
        this.position = position;
    }


    /**
     * Updates the status of the GameObject, e.g. if a GameObject is harmful or not.
     */
    protected abstract void updateStatus();

    /**
     * Draws the GameObject to the canvas.
     */
    public abstract void addToCanvas();

    /**
     * Sets the GamePlayManager, so the game object is able call game-play methods.
     *
     * @param gamePlayManager GamePlayManager that controls this game.
     */
    public void setGamePlayManager(GamePlayManager gamePlayManager) {
        this.gamePlayManager = gamePlayManager;
    }

    /**
     *Updates the position and the status of a gameObject.
     */
    public void update() {
        if (this instanceof MovingGameObject) {
            ((MovingGameObject) this).updatePosition();
        }
        this.updateStatus();
    }

    /**
     * Relocates the GameObject in the play world.
     * @param adaptX Adapts the x-coordiante.
     * @param adaptY Adapts the y-coordiante.
     */
    public void adaptPosition(double adaptX, double adaptY) {
        position.x += adaptX;
        position.y += adaptY;
    }

    /**
     * Counts the GameObjects.
     */
    public void countGameObjects() {

    }
    @Override
    public GameObject clone() {
        GameObject gameObject = null;
        try {
            gameObject = (GameObject) super.clone();
            gameObject.position = position.clone();
        } catch (CloneNotSupportedException ignored) {
        }
        return gameObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return Double.compare(that.speedInPixel, speedInPixel) == 0
                && Double.compare(that.rotation, rotation) == 0
                && Double.compare(that.size, size) == 0 && width == that.width
                && height == that.height && position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, speedInPixel, rotation, size, width, height);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + position;
    }
}

