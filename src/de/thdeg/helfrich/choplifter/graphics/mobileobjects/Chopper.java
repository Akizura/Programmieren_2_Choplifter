package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;

import java.awt.*;

/**
 * Represents a chopper in the game.
 */
public class Chopper extends GameObject {

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
    private boolean moveVertically;
    private boolean moveLeft;
    private boolean moveRight;
    private boolean chopperFront;
    private final int minimumFlingHeight;
    private boolean showGraphics;

    /**
     * Creates a new Chopper.
     *
     * @param gameView GameView to show the Chopper on
     */
    public Chopper(GameView gameView) {
        super(gameView);
        /*super.position = new Position(300, 300);*/
        super.position = new Position((GameView.WIDTH - width) / 2d, (GameView.HEIGHT - height) / 2d);
        super.size = 3.5;
        super.width = (int) (15 * size);
        super.height = (int) (14 * size);
        super.rotation = 0;
        super.speedInPixel = 2;
        this.diagonalMovement = false;
        this.moveLeft = false;
        this.moveRight = false;
        this.moveVertically = true;
        this.chopperFront = false;
        this.numberOfPassengers = 0;
        this.takenDamage = 0;
        this.numberOfLives = 3;
        this.shooting = false;
        this.minimumFlingHeight = 200;
        this.showGraphics = true;
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('L', Color.BLACK);
    }

    /**
     * Draws the Chopper on the canvas.
     */
    @Override
    public void addToCanvas() {
        if (showGraphics == true) {
            if (moveLeft == true) {
                gameView.addBlockImageToCanvas(CHOPPER_LEFT, position.x, position.y, size, 0);
            }
            if (moveRight == true) {
                gameView.addBlockImageToCanvas(CHOPPER_RIGHT, position.x, position.y, size, 0);
            }
            if (moveVertically == true) {
                gameView.addBlockImageToCanvas(CHOPPER_FRONT, position.x, position.y, size, 0);
            }
            /*if (shooting == true) {
                gameView.addTextToCanvas("You are shooting", position.x, position.y, 20, Color.RED, rotation);
                shooting = false;
            }
        } else {
            if (shooting == true) {
                gameView.addTextToCanvas("O", position.x, position.y, 50, Color.RED, rotation);
                shooting = false;
            } else {
                gameView.addTextToCanvas("X", position.x, position.y, 50, Color.WHITE, rotation);
            }*/
        }
    }

    /**
     * Moves the chopper leftwards.
     */
    public void left() {
        moveLeft = true;
        moveRight = false;
        moveVertically = false;
        if(position.x > 300){
        position.left(speedInPixel);
        } else {
            gamePlayManager.chopperMovingLeft(speedInPixel);
        }
    }

    /**
     * Moves the chopper rightwards.
     */
    public void right() {
        moveRight = true;
        moveLeft = false;
        moveVertically = false;
        if(position.x < GameView.WIDTH - width - 300){
            position.right(speedInPixel);
        } else {
            gamePlayManager.chopperMovingRight(speedInPixel);
        }
    }

    /**
     * Moves the copper upwards.
     */
    public void up() {
        moveVertically = true;
        moveLeft = false;
        moveRight = false;
        position.up(speedInPixel);
    }

    /**
     * Moves the chopper downwards.
     */
    public void down() {
        moveVertically = true;
        moveLeft = false;
        moveRight = false;
        position.down(speedInPixel);
    }

    /**
     * With this method the chopper is able to shoot.
     */
    public void shoot() {
        /*shooting = true;*/
        if (gameView.timerExpired("Shot", "Chopper")) {
            gameView.setTimer("Shot", "Chopper", 300);
            gamePlayManager.shootChopperShot(position);
        }
    }

    public double getHeight(){
        return height;
    }

    public boolean getMoveLeft(){
        return moveLeft;
    }

    public boolean getMoveRight(){
        return moveRight;
    }

    public boolean getMoveVertically(){
        return moveVertically;
    }

    @Override
    public void updateStatus(){

    }

    @Override
    public String toString() {
        return "Chopper: (" + "position =" + position + ")";
    }

}
