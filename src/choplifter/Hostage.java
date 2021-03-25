package choplifter;

public class Hostage {
    private String color;
    private double size;
    private double speedInPixel;
    private int takenDamage;
    private boolean alive;
    private boolean passenger;
    private boolean touchedByHelicopter;
    private boolean inRangeOfHelicopter;

    /*public static int numberOfHostagesAlive;
    public  static int numberOfHostagesDead;
    public static int numberOfHostagesRescued;*/

    Position position;
    public double x;
    public double y;
    public double numberOfPixel;

    //constructor
    Hostage() {
        String color = "white";
        double size = 3;
        boolean alive = true;
        boolean passenger = false;
        boolean touchedByHelicopter = false;
        boolean inRangeOfHelicopter = false;
        double speedInPixel = 4;
        this.position = new Position(40, 50);
    }

    //methods
    void updatePosition() {
        position.left(speedInPixel);
    }

    void runToHelicopter(){

    }

    void takeDamage(){

    }

    @Override
    public String toString() {
        return "Hostage: (" + "position=" + position + ")";
    }

}
