package choplifter;

/**
 * Represents the positions of the game objects.
 */
public class Position {
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
     * @param x Represents a value on the X-coordinate.
     * @param y Represents a value on the Y-coordinate.
     */
    Position(double x, double y){
    this.x = x;
    this.y = y;
    }

    /**
     * THe second constructor: Creates a new position with specific values.
     */
    Position(){
        this(0,0);
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
    public void left(){
        x--;
    }
    /**
     * Moves objects one step right.
     */
    public void right(){
        x++;
    }
    /**
     * Moves objects one step up.
     */
    public void up(){
        y--;
    }
    /**
     * Moves objects one step down.
     */
    public void down() { y++; }

    /**
     * Moves objets as many steps left as the number of pixels noted.
     * @param pixel The number of pixel changes how far an object shall be moved.
     */
    public void left(double pixel){
         x-=pixel;
    }
    /**
     * Moves objets as many steps right as the number of pixels noted.
     * @param pixel The number of pixel changes how far an object shall be moved.
     */
    public void right(double pixel){ x += pixel; }
    /**
     * Moves objets as many steps up as the number of pixels noted.
     * @param pixel The number of pixel changes how far an object shall be moved.
     */
    public void up(double pixel){ y -= pixel; }
    /**
     * Moves objets as many steps down as the number of pixels noted.
     * @param pixel The number of pixel changes how far an object shall be moved.
     */
    public void down(double pixel){ y += pixel; }
    
    @Override
    public String toString() {
        return "Position (" + (int) Math.round(x) + ", " + (int) Math.round(y) + ")";
    }
}
