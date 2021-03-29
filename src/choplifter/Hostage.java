package choplifter;
import javax.swing.*;
import java.awt.*;

/**
 * Represents a hostage in the game.
 */
public class Hostage {
    private final double size;
    private final double width;
    private final double height;

    private double rotation;
    private double speedInPixel;
    private int takenDamage;
    private boolean alive;
    private boolean passenger;
    private boolean touchedByHelicopter;
    private boolean inRangeOfHelicopter;

    private Position position;

    /**
     * Creates a new Hostage.
     */
    Hostage() {
        this.size = 3;
        this.height = 10;
        this.width = 5;
        this.rotation = 0;
        this.alive = true;
        this.passenger = false;
        this.touchedByHelicopter = false;
        this.inRangeOfHelicopter = false;
        this.speedInPixel = 4;
        this.position = new Position(40, 50);
    }

    /**
     * Moves the Hostage.
     */
    public void updatePosition() {
        position.left(speedInPixel);
    }

    /**
     * Get the position of a hostage.
     * @return Current position of a hostage.
     * {@link Position}
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    private void runToHelicopter(){

    }

    private void takeDamage(){

    }

    /**
     * Shows a summary of the core information of Hostage.
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Hostage: (" + "position=" + position + ")";
    }

}
