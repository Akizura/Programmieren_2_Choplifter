package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;
import java.util.Random;

/**
 * Represents a jet in the game.
 */
public class Jet extends Shooter implements MovingGameObject {

    private final static String JET_RIGHT =
                    " LLLL                                           \n" +
                    " LaaLLLL                                        \n" +
                    " LaaaLAAL                                       \n" +
                    " LaaaLAAAL                                      \n" +
                    " LaaaaLAAL                                      \n" +
                    " LaaaaLLAAL                                     \n" +
                    " LaaaaaLAAAL                                    \n" +
                    " LaaaaaLLLAAL                   LLLLL           \n" +
                    " LaaaaaaaLAAAL               LLLLdddLLL         \n" +
                    "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLddddddddLL        \n" +
                    "LDDDDDDDDDDDDDDDDDDDDDDDDDDDDLLLLLddddLL        \n" +
                    "LeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeLLLdddLL       \n" +
                    "LEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEELLLLLLLL     \n" +
                    "LfffffffffffffffffffffffffffffffffffffffffL     \n" +
                    "LEEEEEEEEEEELLLLLLLLLLLLLLLLLLLEEEEEEEEEEEEEL   \n" +
                    "LeeeeeeeeeeeeLFFFFFFFFFFFFFFFLeeeeeeeeeeeeeeeeeL\n" +
                    "LDDDDDDDDDDDDDLLLLLLLLLLLLLLLDDDDDDDDDDDDDDLLLLL\n" +
                    "  LaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaLLLLL     \n" +
                    "  LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL         \n";

    private final static String JET_LEFT =
                    "                                           LLLL \n" +
                    "                                        LLLLaaL \n" +
                    "                                       LAALaaaL \n" +
                    "                                      LAAALaaaL \n" +
                    "                                      LAALaaaaL \n" +
                    "                                     LAALLaaaaL \n" +
                    "                                    LAAALaaaaaL \n" +
                    "           LLLLL                   LAALLLaaaaaL \n" +
                    "         LLLdddLLLL               LAAALaaaaaaaL \n" +
                    "        LLddddddddLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
                    "        LLddddLLLLLDDDDDDDDDDDDDDDDDDDDDDDDDDDDL\n" +
                    "       LLdddLLLeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeL\n" +
                    "     LLLLLLLLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEL\n" +
                    "     LfffffffffffffffffffffffffffffffffffffffffL\n" +
                    "   LEEEEEEEEEEEEELLLLLLLLLLLLLLLLLLLEEEEEEEEEEEL\n" +
                    "LeeeeeeeeeeeeeeeeeLFFFFFFFFFFFFFFFLeeeeeeeeeeeeL\n" +
                    "LLLLLDDDDDDDDDDDDDDLLLLLLLLLLLLLLLDDDDDDDDDDDDDL\n" +
                    "     LLLLLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaL  \n" +
                    "         LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL  \n";


    private final static String JET_SIDE_L =
                    "                              WWWWWWWWW             \n" +
                    "                                   DDDD             \n" +
                    "                                  DDDDD             \n" +
                    "                                DDDDDDD             \n" +
                    "                              DDDDDDDDD             \n" +
                    "                            DDDDDDDDDDD          eee\n" +
                    "                         DDDDDDDDDDDDDD        eeee \n" +
                    "                       DDDDDDDDDDDDDDDD       eeee  \n" +
                    "    LeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeW   \n" +
                    " LEEEEEELddddddLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEWW   \n" +
                    "LffffffLddddddddLffffffffffffffffffffffffffffffWW   \n" +
                    " LEEEEEELddddddLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEWW   \n" +
                    "   LeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeW   \n" +
                    "                       DDDDDDDDDDDDDDDD       eeee  \n" +
                    "                         DDDDDDDDDDDDDD        eeee \n" +
                    "                            DDDDDDDDDDD          eee\n" +
                    "                              DDDDDDDDD             \n" +
                    "                                DDDDDDD             \n" +
                    "                                  DDDDD             \n" +
                    "                                   DDDD             \n" +
                    "                              WWWWWWWWW             ";

    private final static String JET_SIDE_R =
                    "             WWWWWWWWW                    \n" +
                    "             DDDD                         \n" +
                    "             DDDDD                        \n" +
                    "             DDDDDDD                      \n" +
                    "             DDDDDDDDD                    \n" +
                    "eee          DDDDDDDDDDD                  \n" +
                    " eeee        DDDDDDDDDDDDDD               \n" +
                    "  eeee       DDDDDDDDDDDDDDDD             \n" +
                    "   WeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeL   \n" +
                    "   WWEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEELddddddLEEEEEEL \n" +
                    "   WWffffffffffffffffffffffffffffffLddddddddLffffffL\n" +
                    "   WWEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEELddddddLEEEEEEL \n" +
                    "   WeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeL   \n" +
                    "  eeee        DDDDDDDDDDDDDDDD             \n" +
                    " eeee         DDDDDDDDDDDDDD               \n" +
                    "eee           DDDDDDDDDDD                  \n" +
                    "              DDDDDDDDD                    \n" +
                    "              DDDDDDD                      \n" +
                    "              DDDDD                        \n" +
                    "              DDDD                         \n" +
                    "              WWWWWWWWW                    ";

    private int bullets;
    private int takenDamage;
    private boolean destroyed;
    private boolean moveFromLeftToRight;
    private Random random;
    private final String objectID;

    /**
     * Creates a new Jet.
     *
     * @param gameView GameView to show the Jet on.
     */
    public Jet(GameView gameView) {
        super(gameView);
        this.random = new Random();
        /*super.position = new Position(48, 250);*/
        super.position = new Position(random.nextInt(gameView.WIDTH-width), 65+height+random.nextInt(gameView.HEIGHT-200));
        super.size = 1.65;
        super.width = (int) (48 * size);
        super.height = (int) (19 * size);
        super.rotation = 0;
        super.speedInPixel = 1;
        this.moveFromLeftToRight = true;
        this.destroyed = false;
        super.shotsPerSecond = 2;
        super.inRangeOfChopper = false;
        super.hitBox = new Rectangle((int) position.x, (int) position.y, width, height-23);
        this.objectID = "Jet" + position.x + position.y;
        gameView.setColorForBlockImage('d', new Color(64, 195, 255));
        gameView.setColorForBlockImage('A', new Color(74, 20, 140));
        gameView.setColorForBlockImage('a', new Color(105, 27, 145));
        gameView.setColorForBlockImage('D', new Color(123, 31, 162));
        gameView.setColorForBlockImage('e', new Color(141, 36, 170));
        gameView.setColorForBlockImage('E', new Color(156, 39, 176));
        gameView.setColorForBlockImage('f', new Color(255, 190, 231));
        gameView.setColorForBlockImage('F', new Color(186, 104, 200));
        gameView.setColorForBlockImage('L', Color.BLACK);
    }

    @Override
    protected void updateHitBoxPosition() {
        hitBox = new Rectangle((int) position.x+5, (int) position.y+13, hitBox.width, hitBox.height);
    }

    @Override
    protected void reactToCollision(CollidableGameObject otherObject) {

    }

    /**
     * Draws the Jet to the canvas.
     */
    @Override
    public void addToCanvas() {
        if (moveFromLeftToRight == true) {
            /*gameView.addBlockImageToCanvas(JET_RIGHT, position.x, position.y, size, rotation);*/
            gameView.addBlockImageToCanvas(JET_SIDE_R, position.x, position.y, size, rotation);
        } else {
            /*gameView.addBlockImageToCanvas(JET_LEFT, position.x, position.y, size, rotation);*/
            gameView.addBlockImageToCanvas(JET_SIDE_L, position.x, position.y, size, rotation);
        }
        gameView.addRectangleToCanvas(hitBox.x, hitBox.y, hitBox.width, hitBox.height, 1, false, Color.RED);
    }

    /**
     * Moves the Jet.
     */
    @Override
    public void updatePosition() {
        if (moveFromLeftToRight == true & position.x < 960 - width) {
            position.right(speedInPixel);
        } else {
            moveFromLeftToRight = false;
            if (moveFromLeftToRight == false) {
                position.left(speedInPixel);
                if (position.x <= 0) {
                    moveFromLeftToRight = true;
                }
            }
        }
    }

    @Override
    public void updateStatus(){
        shoot();
    }

    private void shoot() {
        if (gameView.timerExpired("Shoot", objectID)) {
            gameView.setTimer("Shoot", objectID, 1000);
            gamePlayManager.shootJetShot(position);
        }
    }

    private void takeDamage() {

    }

    public boolean getMoveFromLeftToRight(){
        return moveFromLeftToRight;
    }

    /**
     * Shows a summary of the core information of Jet.
     *
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Jet: (" + "position=" + position + ")";
    }
}
