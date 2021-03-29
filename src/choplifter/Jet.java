package choplifter;

import javax.swing.*;
import java.awt.*;

/** Represents a jet in the game.*/
public class Jet {
    private final double size;
    private final double width;
    private final double height;

    private double speedInPixel;
    private double rotation;
    private int bullets;
    private int takenDamage;
    private boolean destroyed;

    private Position position;

    /**
     * Creates a new Jet.
     */
    Jet(){
        this.destroyed = false;
        this.speedInPixel = 2;
        this.position = new Position(48, 300);
        this.rotation = 0;
        this.size = 2;
        this.width = (int) (48 * size);
        this.height = (int) (19 * size);
    }

    /**
     * Moves the Jet.
     */
    public void updatePosition() {
                position.right(speedInPixel);
    }

    /**
     * Get the position of a jet.
     * @return Current position of a jet.
     * {@link Position}
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    private void shoot() {

    }

    private void takeDamage() {

    }

    /**
     * Shows a summary of the core information of Jet.
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Jet: (" + "position=" + position + ")";
    }
}
