package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

/**
 * Represents a drone in the game.
 */
public class Drone extends Enemy implements MovingGameObject {

    public enum Status {FOLLOW, EXPLODE, DESTROYED}

    private final static String DRONE =
                    "Y                                 Y\n" +
                    " W            RRRRRRR            W \n" +
                    "  W         RRRRRRRRRRR         W  \n" +
                    "   W      RRRRRRRRRRRRRRR      W   \n" +
                    "    W   RRRRRRRRRRRRRRRRRRR   W    \n" +
                    "    WW RRRRRRRRRRRRRRRRRRRRR WW    \n" +
                    "     WWRRRRRRRRRRRRRRRRRRRRRWW     \n" +
                    "     WRRRRRRRRRRRRRRRRRRRRRRRW     \n" +
                    "     WRRRRRRRRRRRRRRRRRRRRRRRW     \n" +
                    "     RRRRLRRRRRRRRRRRRRRRLRRRR     \n" +
                    "     RRRRRRLRRRRRRRRRRRLRRRRRR     \n" +
                    "     RRRRRRRRLRRRRRRRLRRRRRRRR     \n" +
                    "     RRRRRRRRRLRRRRRLRRRRRRRRR     \n" +
                    "     RRRRRRRRRRRRRRRRRRRRRRRRR     \n" +
                    "     RRRRRRRRRRRRRRRRRRRRRRRRR     \n" +
                    "     RRRRLLLLLRRRRRRRLLLLLRRRR     \n" +
                    "     RRRRLLLLLRRRRRRRLLLLLRRRR     \n" +
                    "     RRRRRLLLRRRRRRRRRLLLRRRRR     \n" +
                    "     RRRRRLLLRRRRRRRRRLLLRRRRR     \n" +
                    "     RRRRRRRRRRRRRRRRRRRRRRRRR     \n" +
                    "     RRRRRRRRRRRRLRRRRRRRRRRRR     \n" +
                    "     RRRRRRRRRRLRRRLRRRRRRRRRR     \n" +
                    "     RRRRRRRRLRRRRRRRLRRRRRRRR     \n" +
                    "      RRRRRRRRRRRRRRRRRRRRRRR      \n";

    private boolean flyFromLeftToRight;
    private int bullets;
    private int takenDamage;
    private boolean destroyed;
    private boolean exploded;
    private String objectID;
    private Random random;
    private Drone.Status status;
    Position targetPosition;
    private final Chopper followMe;

    /**
     * Creates a drone.
     * @param gameView GameView to show the Drone on.
     * @param followMe Chopper to follow
     * @param objectsToCollideWith Game objects this game object can collide with.
     */
    public Drone(GameView gameView, Chopper followMe, ArrayList<CollidableGameObject> objectsToCollideWith) {
        super(gameView, objectsToCollideWith);
        LinkedList<Drone> drones = new LinkedList<>();
        super.gameView = gameView;
        this.random = new Random();
        /*super.position = new Position(48, 160);*/
        super.position = new Position(random.nextInt(gameView.WIDTH-width), (65+height)+random.nextInt(gameView.HEIGHT-200));
        super.size = 0.9;
        super.width = (int) (35 * size);
        super.height = (int) (24 * size);
        super.rotation = 0;
        super.speedInPixel = 0.3;
        this.flyFromLeftToRight = true;
        this.destroyed = false;
        this.exploded = false;
        super.inRangeOfChopper = false;
        super.hitBox = new Rectangle((int) position.x, (int) position.y, width-10, height-5);
        this.objectID = "Drone" + position.x + position.y;
        this.status = Status.FOLLOW;
        this.followMe = followMe;
        gameView.setColorForBlockImage('R', new Color(187, 35, 75));
        gameView.setColorForBlockImage('L', Color.BLACK);
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('Y', Color.YELLOW);
        gameView.setColorForBlockImage('n', new Color(84, 22, 7));
    }

    @Override
    protected void updateHitBoxPosition() {
        hitBox = new Rectangle((int) position.x+5, (int) position.y+5, hitBox.width, hitBox.height);
    }

    @Override
    protected void reactToCollision(CollidableGameObject otherObject) {
    }


    /**
     * Draws the Drone to the canvas.
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(DRONE, position.x, position.y, size, rotation);
        gameView.addRectangleToCanvas(hitBox.x, hitBox.y, hitBox.width, hitBox.height, 1, false, Color.RED);
    }

    /**
     * Moves the Drone.
     */
    @Override
    public void updatePosition() {
        if (flyFromLeftToRight & position.x < 960 - width) {
            position.right(speedInPixel);
        } else {
            flyFromLeftToRight = false;
            if (!flyFromLeftToRight) {
                position.left(speedInPixel);
                if (position.x <= 0) {
                    flyFromLeftToRight = true;
                }
            }
        }
        if (status == Drone.Status.FOLLOW) {
            targetPosition = followMe.getPosition().clone();
        }

        if (status != Drone.Status.DESTROYED) {
            double distance = position.distance(targetPosition);
            if (distance >= speedInPixel) {
                position.right((targetPosition.x - position.x) / distance * speedInPixel);
                position.down((targetPosition.y - position.y) / distance * speedInPixel);
            }
        }
    }

    @Override
    public void updateStatus(){

    }

    private void explode() {

    }

    private void takeDamage() {

    }

    @Override
    public Drone clone() {
        return (Drone) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drone drone = (Drone) o;
        return inRangeOfChopper == drone.inRangeOfChopper && flyFromLeftToRight == drone.flyFromLeftToRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inRangeOfChopper, flyFromLeftToRight);
        }
}
