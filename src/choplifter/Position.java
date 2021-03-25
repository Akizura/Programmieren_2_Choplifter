package choplifter;

public class Position {
    public double x;
    public double y;

    //constructor
    Position(double x, double y){
    this.x = x;
    this.y = y;
    }

    //second constructor
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
    //Directions
    public void left(){
        x--;
    }
    public void right(){
        x++;
    }
    public void up(){
        y--;
    }
    public void down() { y++; }

    //Specific Directions
    public void left(double pixel){
         x-=pixel;
    }
    public void right(double pixel){
        x += pixel;
    }
    public void up(double pixel){
        y -= pixel;
    }
    public void down(double pixel){
        y += pixel;
    }

    @Override
    public String toString() {
        return "Position (" + (int) Math.round(x) + ", " + (int) Math.round(y) + ")";
    }
}
