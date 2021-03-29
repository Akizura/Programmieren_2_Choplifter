package choplifter;
import javax.swing.*;
import java.awt.*;

/** Represents a tank in the game.*/
public class Tank {

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
     * Creates a new tank-
     */
    Tank() {
        this.size = 5;
        this.destroyed = false;
        this.speedInPixel = 1;
        this.position = new Position(30, 40);
        this.rotation = 0;
        this.width = (int) (5 * size);
        this.height = (int) (5 * size);
    }

    /**
     * Moves the Tank.
     */
    public void updatePosition() {
        position.right(speedInPixel);
    }

    /**
     * Get the position of a tank.
     * @return Current position of a tank.
     * {@link Position}
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    private void shoot(){

    }

    private void takeDamage(){

    }

    /**
     * Shows a summary of the core information of Tank.
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Tank: (" + "position=" + position + ")";
    }
}
