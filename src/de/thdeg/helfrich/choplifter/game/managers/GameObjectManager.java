package de.thdeg.helfrich.choplifter.game.managers;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.*;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Background;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Barracks;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Base;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Border;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * This class manages the game objects.
 */
    public class GameObjectManager {

    private GameView gameView;

    private final Barracks barracks;
    private final Hostage hostage;
    private final Base base;
    private final Chopper chopper;
    private final Background background;
    private final Border border;

    private LinkedList<ChopperShot> chopperShots;
    private LinkedList<Jet> jets;
    private LinkedList<JetShot> jetShots;
    private LinkedList<Tank> tanks;
    private LinkedList<TankShot> tankShots;
    private LinkedList<Drone> drones;
    private LinkedList<Hostage> hostages;
    private LinkedList<GameObject> gameObjects;

    /**
     * Creates a new GameObjectManager.
     *
     * @param gameView Window to show the GameObjects on-
     */
    public GameObjectManager(GameView gameView) {
        this.gameView = gameView;
        this.barracks = new Barracks(gameView);
        this.hostage = new Hostage(gameView);
        this.chopper = new Chopper(gameView);
        this.base = new Base(gameView);
        this.background = new Background(gameView);
        this.border = new Border(gameView);

        this.chopperShots = new LinkedList<>();
        this.jets = new LinkedList<>();
        this.jetShots = new LinkedList<>();
        this.tanks = new LinkedList<>();
        this.tankShots = new LinkedList<>();
        this.drones = new LinkedList<>();
        this.hostages = new LinkedList<>();
        this.gameObjects = new LinkedList<>();
    }


    /**
     * This method updates the position of the GameObjects and draws them to the canvas.
     */
    public void updateGameObjects() {

        gameObjects.clear();

        gameObjects.add(background);
        gameObjects.add(base);
        gameObjects.add(barracks);
        gameObjects.add(chopper);

        gameObjects.addAll(chopperShots);
        gameObjects.addAll(drones);
        gameObjects.addAll(tanks);
        gameObjects.addAll(tankShots);
        gameObjects.addAll(jets);
        gameObjects.addAll(jetShots);
        gameObjects.addAll(hostages);

        for (var gameObject : gameObjects) {
            gameObject.update();
            gameObject.addToCanvas();
        }
    }

    /**
     * Getter method for the chopper.
     *
     * @return chopper
     */
    public Chopper getChopper() {
        return chopper;
    }

    /**
     * Getter method for the LinkedList jets.
     * @return Shows the containing elements of jets.
     */
    public LinkedList<Jet> getJets() {
        return jets;
    }

    /**
     * Getter method for the LinkedList tanks.
     * @return Shows the containing elements of tanks.
     */
    public LinkedList<Tank> getTanks() {
        return tanks;
    }

    /**
     * Getter method for the LinkedList drones.
     * @return Shows the containing elements of drones
     */
    public LinkedList<Drone> getDrones() {
        return drones;
    }

    /**
     * Getter method for the LinkedList hostages.
     * @return Shows the containing elements of hostages.
     */
    public LinkedList<Hostage> getHostages() {
        return hostages;
    }

    /**
     * Getter method for the LinkedList gameObjects.
     * @return Shows the containing elements of gameObjects.
     */
    public LinkedList<GameObject> getGameObjects() {
        return gameObjects;
    }

    /**
     * Getter method for the LinkedList chopperShots.
     * @return chopperShots
     */
    public LinkedList<ChopperShot> getChopperShots() {
        return chopperShots;
    }

    /**
     * Getter method for the LinkedList jetShots.
     * @return jetShots
     */
    public LinkedList<JetShot> getJetShots() {
        return jetShots;
    }

    /**
     * Getter method for the LinkedList tankShots-
     * @return tankshots
     */
    public LinkedList<TankShot> getTankShots() {
        return tankShots;
    }
}
