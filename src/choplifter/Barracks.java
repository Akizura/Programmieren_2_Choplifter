package choplifter;
/**
 * Represents a Barracks in the game.
 */
public class Barracks {

    private final double size;
    private final double width;
    private final double height;

    private double rotation;
    private boolean closed;
    private int takenDamage;
    private boolean destroyed;
    private int hostagesInside;

    private Position position;

    /**
     * Creates a new Barracks.
     */
    Barracks(){
        this.size=5;
        this.width = 40;
        this.height = 25;
        this.rotation = 0;
        this.rotation = 0;
        this.closed = true;
        this.destroyed = false;
        this.hostagesInside = 16;
    }

    /**
     * Get the position of a barracks.
     * @return Current position of a barracks.
     * {@link Position}
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Get the number of hostages inside a barracks.
     * @return Number of hostages
     */
    public int getHostagesInside() {
        return hostagesInside;
    }

    /**
     * Shows, if a barracks is closed or not.
     * @return closed: true or false
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Shows, if a barracks is destroyed or not.
     * @return destroyed: true or false
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    private void takeDamage () {

    }

    /**
     * Shows a summary of the core information of Barracks.
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Barracks: (" + "position=" + position + ")";
    }
}
