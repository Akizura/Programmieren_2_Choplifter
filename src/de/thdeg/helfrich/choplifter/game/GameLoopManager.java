package de.thdeg.helfrich.choplifter.game;
import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.gameobjects.*;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**This class manages the main game loop of the game. */
public class GameLoopManager {
    private final GameView gameView;
    private final Jet jet;
    private final Drone drone;
    private final Tank tank;
    private final Barracks barracks;
    private final Hostage hostage;
    private final Chopper chopper;
    private static final boolean DIAGONALMOVEMENT = false;

    /*
    private String rightHelicopter;
    private String leftHelicopter;
    private String frontHelicopter;
    */

    /** Creates the main loop. */
    public GameLoopManager() {
        this.gameView = new GameView();
        this.gameView.setWindowTitle("Choplifter");
        this.gameView.setStatusText("Laura Helfrich - Java Programmierung SS 2021");
        this.gameView.setWindowIcon("WordHelicopter.png");

        this.jet = new Jet(gameView);
        this.drone = new Drone(gameView);
        this.tank = new Tank(gameView);
        this.barracks = new Barracks(gameView);
        this.hostage = new Hostage(gameView);
        this.chopper = new Chopper(gameView);

    }

    /**
     * This enables the user to take action.
     */
    public void updateUserInputs () {
        Integer[] pressedKeys = gameView.getKeyCodesOfCurrentlyPressedKeys();
        if(DIAGONALMOVEMENT==true){
            directions();
        }
        else{
            if(DIAGONALMOVEMENT==false) {
                for (int keyCode : pressedKeys) {
                    if (keyCode == KeyEvent.VK_UP) {
                        chopper.up();
                        break;
                    }
                    if (keyCode == KeyEvent.VK_DOWN) {
                        chopper.down();
                        break;
                    }
                    if (keyCode == KeyEvent.VK_RIGHT) {
                        chopper.right();
                        break;
                    }
                    if (keyCode == KeyEvent.VK_LEFT) {
                        chopper.left();
                        break;
                    }
                    if (keyCode == KeyEvent.VK_SPACE) {
                        chopper.shoot();
                        break;
                    }
                }
            }
        }
    }

    /**
     * This manages the directions the user can move to.
     */
        public void directions() {
        Integer[] pressedKeys = gameView.getKeyCodesOfCurrentlyPressedKeys();
        for (int keyCode : pressedKeys) {
            if (keyCode == KeyEvent.VK_UP) {
                chopper.up();
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                chopper.down();
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                chopper.right();
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                chopper.left();
            }
            if (keyCode == KeyEvent.VK_SPACE) {
                chopper.shoot();
            }
        }
    }

    /** Starts the main loop of the game. */
    public void startGame() {
        while(true) {
            //Updating the userinputs
            updateUserInputs();

            //Represents the background
            this.gameView.addRectangleToCanvas(0,440,960,100,5,true,Color.GRAY);

            //Updates the positions of the GameObjects
            jet.updatePosition();
            drone.updatePosition();
            tank.updatePosition();
            hostage.updatePosition();

            //Draws the GameObjects to the canvas
            jet.addToCanvas();
            drone.addToCanvas();
            tank.addToCanvas();
            barracks.addToCanvas();
            hostage.addToCanvas();
            chopper.addToCanvas();

            gameView.printCanvas();
        }
    }
}
