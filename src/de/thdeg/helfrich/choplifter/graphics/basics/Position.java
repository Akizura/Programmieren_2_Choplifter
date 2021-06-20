package de.thdeg.helfrich.choplifter.graphics.basics;

import java.util.Objects;

/**
 * Represents the positions of the game objects.
 */
public class Position implements Cloneable, Comparable<Position> {
    /**
     * Represents a value on the X-coordinate.
     */
    public double x;
    /**
     * Represents a value on the Y-coordinate.
     */
    public double y;

    /**
     * The first constructor: Creates a new position.
     *
     * @param x Represents a value on the X-coordinate.
     * @param y Represents a value on the Y-coordinate.
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * THe second constructor: Creates a new position with specific values.
     */
    Position() {
        this(0, 0);
    }

    /*
    public double getX(){
        return x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return y;
    }
    public void setY(){
        this.y = y;
    }
*/

    /**
     * Moves objects one step left.
     */
    public void left() {
        x--;
    }

    /**
     * Moves objects one step right.
     */
    public void right() {
        x++;
    }

    /**
     * Moves objects one step up.
     */
    public void up() {
        y--;
    }

    /**
     * Moves objects one step down.
     */
    public void down() {
        y++;
    }

    /**
     * Moves objets as many steps left as the number of pixels noted.
     *
     * @param pixel The number of pixel changes how far an object shall be moved.
     */
    public void left(double pixel) {
        x -= pixel;
    }

    /**
     * Moves objets as many steps right as the number of pixels noted.
     *
     * @param pixel The number of pixel changes how far an object shall be moved.
     */
    public void right(double pixel) {
        x += pixel;
    }

    /**
     * Moves objets as many steps up as the number of pixels noted.
     *
     * @param pixel The number of pixel changes how far an object shall be moved.
     */
    public void up(double pixel) {
        y -= pixel;
    }

    /**
     * Moves objets as many steps down as the number of pixels noted.
     *
     * @param pixel The number of pixel changes how far an object shall be moved.
     */
    public void down(double pixel) {
        y += pixel;
    }

    /**
     * Calculates the distance to any other position.
     *
     * @param other Position to calculate the distance to.
     * @return The distance.
     */
    public double distance(Position other) {
        return Math.sqrt(Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2));
    }

    @Override
    public String toString() {
        return "Position (" + (int) Math.round(x) + ", " + (int) Math.round(y) + ")";
    }

    @Override
    public Position clone() {
        Position clone = null;
        try {
            clone = (Position) super.clone();
        } catch (CloneNotSupportedException ignored) {

        }
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Position o) {
        return (int) Math.signum(this.distance(o));
    }
}
