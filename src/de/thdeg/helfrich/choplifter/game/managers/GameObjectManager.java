package de.thdeg.helfrich.choplifter.game.managers;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.*;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Barracks;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Base;

import java.awt.Color;

/**
 * This class manages the game objects.
 */
public class GameObjectManager {

    private GameView gameView;
    private final Jet jet;
    private final Drone drone;
    private final Tank tank;
    private final Barracks barracks;
    private final Hostage hostage;
    private final Base base;
    private final Chopper chopper;

    /**
     * Creates a new GameObjectManager.
     * @param gameView Window to show the GameObjects on-
     */
    public GameObjectManager(GameView gameView) {
        this.gameView = gameView;
        this.jet = new Jet(gameView);
        this.drone = new Drone(gameView);
        this.tank = new Tank(gameView);
        this.barracks = new Barracks(gameView);
        this.hostage = new Hostage(gameView);
        this.chopper = new Chopper(gameView);
        this.base = new Base(gameView);
    }

    /**
     *This method updates the position of the GameObjects and draws them to the canvas.
     */
    public void updateGameObjects(){

            //Represents the background

            this.gameView.addRectangleToCanvas(0,440,960,100,5,true, Color.GRAY);

            //Updates the positions of the GameObjects
            jet.updatePosition();
            drone.updatePosition();
            tank.updatePosition();
            hostage.updatePosition();

            //Draws the GameObjects to the canvas
            base.addToCanvas();
            barracks.addToCanvas();
            jet.addToCanvas();
            drone.addToCanvas();
            tank.addToCanvas();
            hostage.addToCanvas();
            chopper.addToCanvas();
        }

    /**
     * Getter method for the chopper.
     * @return chopper
     */
    public Chopper getChopper() {
        return chopper;
    }
}
