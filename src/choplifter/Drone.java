package choplifter;
import java.awt.*;

/**
 * Represents a drone in the game.
 */
public class Drone {
    private final double size;
    private final double width;
    private final double height;

    private double speedInPixel;
    private boolean flyFromLeftToRight;
    private double rotation;
    private int bullets;
    private int takenDamage;
    private boolean destroyed;

    private Position position;

    /**
     * Creates a new Drone.
     */
    Drone(){
        this.flyFromLeftToRight = true;
        this.destroyed = false;
        this.speedInPixel = 1;
        this.position = new Position(48, 200);
        this.rotation = 0;
        this.size = 1;
        this.width = (int) (11 * size);
        this.height = (int) (11 * size);
    }

    /**
     * Moves the Drone.
     */
    public void updatePosition() {
        position.right(speedInPixel);
    }

    /**
     * Get the position of a drone.
     * @return Current position of a drone.
     * {@link Position}
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Shows a summary of the core information of Drone.
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Drone: (" + "position=" + position + ")";
    }
}
