package choplifter;

public class Tank {
    public String color;
    public double size;
    public double speedInPixel;
    private int bullets;
    private int takenDamage;
    private boolean destroyed;
    Position position;
    private double width;
    private double height;

    Tank() {
        this.color = "brown";
        this.size = 5;
        this.destroyed = false;
        this.speedInPixel = 5;
        this.position = new Position(30, 40);
        this.width = (int) (5 * size);
        this.height = (int) (5 * size);
    }

    void updatePosition() {
        position.left(speedInPixel);
    }

    void shoot(){

    }

    void takeDamage(){

    }

    @Override
    public String toString() {
        return "Tank: (" + "position=" + position + ")";
    }
}
