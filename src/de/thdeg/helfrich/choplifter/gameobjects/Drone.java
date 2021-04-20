package de.thdeg.helfrich.choplifter.gameobjects;
import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

/**
 * Represents a drone in the game.
 */
public class Drone extends Enemies{

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

    /**
     * Creates a new Drone.
     * @param gameView GameView to show the Drone on.
     */
    public Drone(GameView gameView){
        super(gameView);
        super.gameView = gameView;
        super.position = new Position(48, 160);
        super.size = 1;
        super.width = (int) (35 * size);
        super.height = (int) (24 * size);
        super.rotation = 0;
        super.speedInPixel = 0.25;
        this.flyFromLeftToRight = true;
        this.destroyed = false;
        this.exploded = false;
        super.inRangeOfChopper = false;
        gameView.setColorForBlockImage('R', Color.RED);
        gameView.setColorForBlockImage('L', Color.BLACK);
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('Y', Color.YELLOW);
        gameView.setColorForBlockImage('n', new Color(84, 22, 7));
    }

    /**
     *Draws the Drone to the canvas.
     */
    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(DRONE, position.x, position.y, size, rotation);
    }

    /**
     * Moves the Drone.
     */
    @Override
    public void updatePosition() {
        if (flyFromLeftToRight == true & position.x < 960 - width) {
            position.right(speedInPixel);
        } else {
            flyFromLeftToRight = false;
            if (flyFromLeftToRight == false) {
                position.left(speedInPixel);
                if(position.x <= 0){
                    flyFromLeftToRight = true;
                }
            }
        }
    }

    private void explode(){

    }

    private void takeDamage(){

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