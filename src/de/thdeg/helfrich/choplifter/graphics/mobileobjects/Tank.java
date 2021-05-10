package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Represents a tank in the game.
 */
public class Tank extends Shooter implements MovingGameObject {

    private final static String TANK_RIGHT =
                    "                     nnKKKKKnKKKKKnnnnKWWKnK \n" +
                    "                     KNnnKnnnnnnnnnKKnnnnnnn \n" +
                    "                     nnnnnnKKKKnKKKKKKKnKKKK \n" +
                    "                    nnnKnnKKnn               \n" +
                    "                    nnKKKKKKKK               \n" +
                    "                    nnnnnnnnnn               \n" +
                    "          qqqqqqqqqqqqqqqqqqqqqqqqq          \n" +
                    "        PPPPPPPPPPPPPPPPPPPPPPPPPPPPP        \n" +
                    "       ppppppppppppppppppppppppppppppp       \n" +
                    "      NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN      \n" +
                    "      nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn      \n" +
                    "   KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK   \n" +
                    "  KKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKK  \n" +
                    " KWKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKWK \n" +
                    "KKKKQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQKKKK\n" +
                    "KWKQsssssssssssssssssssssssssssssssssssssQKWK\n" +
                    "KKKKQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQKKKK\n" +
                    " KWKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKWK \n" +
                    "  KKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKK  \n" +
                    "   KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK   ";

    private final static String TANK_LEFT =
                    "       KnKWWKnnnnKKKKKnKKKKKnn               \n" +
                    "       nnnnnnnKKnnnnnnnnnKnnNK               \n" +
                    "       KKKnKKKKKKKnKKKKnnnnnn                \n" +
                    "                    nnKnnKKnnn               \n" +
                    "                    KKKKKKKKnn               \n" +
                    "                    nnnnnnnnnn               \n" +
                    "          qqqqqqqqqqqqqqqqqqqqqqqqq          \n" +
                    "        PPPPPPPPPPPPPPPPPPPPPPPPPPPPP        \n" +
                    "       ppppppppppppppppppppppppppppppp       \n" +
                    "      NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN      \n" +
                    "      nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn      \n" +
                    "   KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK   \n" +
                    "  KKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKK  \n" +
                    " KWKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKWK \n" +
                    "KKKKQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQKKKK\n" +
                    "KWKQsssssssssssssssssssssssssssssssssssssQKWK\n" +
                    "KKKKQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQKKKK\n" +
                    " KWKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKWK \n" +
                    "  KKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKKKWKK  \n" +
                    "   KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK   ";

    private int bullets;
    private int takenDamage;
    private boolean destroyed;
    private boolean flyFromLeftToRight;
    private String objectID;
    private Random random;

    /**
     * Creates a new Tank.
     *
     * @param gameView GameView to show the Tank on.
     */
    public Tank(GameView gameView) {
        super(gameView);
        LinkedList<Tank> tanks = new LinkedList<>();
        super.gameView = gameView;
        this.random = new Random();
        /*super.position = new Position(30, 470);*/
        super.position = new Position (random.nextInt(gameView.WIDTH-0)-0, gameView.HEIGHT-random.nextInt(130));
        super.size = 1.5;
        super.width = (int) (45 * size);
        super.height = (int) (20 * size);
        super.rotation = 0;
        super.speedInPixel = 0.5;
        this.flyFromLeftToRight = true;
        this.destroyed = false;
        super.shotsPerSecond = 2;
        super.inRangeOfChopper = false;
        this.objectID = "Tank" + position.x + position.y;
        gameView.setColorForBlockImage('K', new Color(94, 55, 40));
        gameView.setColorForBlockImage('n', new Color(84, 22, 7));
        gameView.setColorForBlockImage('N', new Color(112, 29, 8));
        gameView.setColorForBlockImage('p', new Color(135, 52, 32));
        gameView.setColorForBlockImage('P', new Color(148, 47, 24));
        gameView.setColorForBlockImage('q', new Color(179, 53, 25));
        gameView.setColorForBlockImage('Q', new Color(71, 41, 35));
        gameView.setColorForBlockImage('s', new Color(107, 90, 87));
        gameView.setColorForBlockImage('W', Color.WHITE);
    }

    /**
     * Draws the tank to the canvas.
     */
    @Override
    public void addToCanvas() {
        if (flyFromLeftToRight == true) {
            gameView.addBlockImageToCanvas(TANK_RIGHT, position.x, position.y, size, rotation);
        } else {
            gameView.addBlockImageToCanvas(TANK_LEFT, position.x, position.y, size, rotation);
        }
    }

    /**
     * Moves the Tank.
     */
    @Override
    public void updatePosition() {
        if (flyFromLeftToRight == true & position.x < 960 - width) {
            position.right(speedInPixel);
        } else {
            flyFromLeftToRight = false;
            if (flyFromLeftToRight == false) {
                position.left(speedInPixel);
                if (position.x <= 0) {
                    flyFromLeftToRight = true;
                }
            }
        }
    }

    private void shoot() {
        if (gameView.timerExpired("Shoot", objectID)) {
            gameView.setTimer("Shoot", objectID, 300);
            gamePlayManager.shootTankShot(position);
        }
    }

    private void takeDamage() {

    }

    @Override
    public void updateStatus(){
        shoot();
    }

    /**
     * Shows a summary of the core information of Tank.
     *
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Tank: (" + "position=" + position + ")";
    }
}
