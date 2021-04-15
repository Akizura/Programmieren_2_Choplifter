package de.thdeg.helfrich.choplifter.gameobjects;

import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

/**
 * Represents a chopper in the game.
 */
public class Chopper extends GameObject{

    /**
     * BlockImage chopper in three different perspectives*
     */
        private final static String CHOPPER_RIGHT =
                "        W      \n" +
                "  WWWWWWWWWWWWW\n" +
                "W       W      \n" +
                " W       W     \n" +
                "  W    WWWWW   \n" +
                "  WWWWWWWWWWW  \n" +
                "  W   WWWWWLLW \n" +
                "  W   WWWWWLLLW\n" +
                "      WWWWWWWWW\n" +
                "       WWWWWWW \n" +
                "        W W    \n" +
                "       W   W  W\n" +
                "     WWWWWWWWW \n";

        private final static String CHOPPER_LEFT =
                        "      W        \n" +
                        "WWWWWWWWWWWWW  \n" +
                        "      W       W\n" +
                        "     W       W \n" +
                        "   WWWWW    W  \n" +
                        "  WWWWWWWWWWW  \n" +
                        " WLLWWWWW   W  \n" +
                        "WLLLWWWWW   W  \n" +
                        "WWWWWWWWW      \n" +
                        " WWWWWWW       \n" +
                        "    W W        \n" +
                        "W  W   W       \n" +
                        " WWWWWWWWW     \n";

        private final static String CHOPPER_FRONT =
                "       W       \n" +
                " WWWWWWWWWWWWW \n" +
                "       W       \n" +
                "       W       \n" +
                "      WWW      \n" +
                "    WWWWWWW    \n" +
                "   WWLLLLLWW   \n" +
                "   WWLLLLLWW   \n" +
                "   WWWWWWWWW   \n" +
                "    WWWWWWW    \n" +
                "     WWWWW     \n" +
                "    W     W    \n" +
                "   W       W   \n";

    private int takenDamage;
    private int numberOfLives;
    private int numberOfPassengers;
    private final static int MAXNUMBEROFPASSENGERS = 16;
    private boolean shooting;
    private boolean diagonalMovement;

    /**
     * Creates a new Chopper.
     * @param gameView GameView to show the Chopper on
     */
    public Chopper(GameView gameView){
        super(gameView);
        super.gameView = gameView;
        super.position = new Position(300,300);
        super.size = 1;
        super.width = (int) (15 * size);
        super.height = (int) (14 * size);
        super.rotation = 0;
        super.speedInPixel = 2;
        this.diagonalMovement = false;
        this.numberOfPassengers = 0;
        this.takenDamage = 0;
        this.numberOfLives = 3;
        this.shooting = false;
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('L', Color.BLACK);
    }

    /**
     * Draws the Chopper on the canvas.
     */
    @Override
    public void addToCanvas() {
        if (shooting ==false) {
            gameView.addTextToCanvas("X", position.x, position.y, 50, Color.WHITE, rotation);
        } else {
            gameView.addTextToCanvas("O",position.x, position.y, 50, Color.RED, rotation);
            shooting=false;
        }
        /*gameView.addBlockImageToCanvas(CHOPPER_RIGHT, position.x, position.y, size, rotation);*/
    }

    @Override
    public void updatePosition(){}

    /**
     * Moves the chopper leftwards.
     */
    public void left () {
        position.left(speedInPixel);
    }

    /**
     * Moves the chopper rightwards.
     */
    public void right () {
        position.right(speedInPixel);
    }

    /**
     * Moves the copper upwards.
     */
    public void up () {
        position.up(speedInPixel);
    }

    /**
     * Moves the chopper downwards.
     */
    public void down () {
        position.down(speedInPixel);
    }

    /**
     * With this method the chopper is able to shoot.
     */
    public void shoot(){
        shooting = true;
    }

    @Override
    public String toString(){
        return "Chopper: (" + "position =" + position + ")";
    }

}
