package de.thdeg.helfrich.choplifter.game.managers;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.*;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.*;

import java.util.LinkedList;

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
    private final Ground ground;
    private final ScoreBoard scoreBoard;
    private final FixedStar fixedStar;
    private final Mountain mountain;
    private final Skyline skyline;

    private LinkedList<ChopperShot> chopperShots;
    private LinkedList<Jet> jets;
    private LinkedList<JetShot> jetShots;
    private LinkedList<Tank> tanks;
    private LinkedList<TankShot> tankShots;
    private LinkedList<Drone> drones;
    private LinkedList<Hostage> hostages;
    private LinkedList<GameObject> gameObjects;
    private LinkedList<MovingStar> movingStars;

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
        this.ground = new Ground(gameView);
        this.scoreBoard = new ScoreBoard(gameView);
        this.fixedStar = new FixedStar(gameView);
        this.mountain = new Mountain(gameView);
        this.skyline = new Skyline(gameView);

        this.chopperShots = new LinkedList<>();
        this.jets = new LinkedList<>();
        this.jetShots = new LinkedList<>();
        this.tanks = new LinkedList<>();
        this.tankShots = new LinkedList<>();
        this.drones = new LinkedList<>();
        this.hostages = new LinkedList<>();
        this.gameObjects = new LinkedList<>();
        this.movingStars = new LinkedList<>();
    }


    /**
     * This method updates the position of the GameObjects and draws them to the canvas.
     */
    public void updateGameObjects() {

        gameObjects.clear();

        gameObjects.add(background);
        gameObjects.add(fixedStar);
        gameObjects.addAll(movingStars);
        gameObjects.add(scoreBoard);
        gameObjects.add(ground);
        gameObjects.add(skyline);
        gameObjects.add(mountain);
        gameObjects.add(border);
        gameObjects.add(base);
        gameObjects.add(barracks);
        gameObjects.add(chopper);

        gameObjects.addAll(hostages);
        gameObjects.addAll(chopperShots);
        gameObjects.addAll(drones);
        gameObjects.addAll(tanks);
        gameObjects.addAll(tankShots);
        gameObjects.addAll(jets);
        gameObjects.addAll(jetShots);


        for (var gameObject : gameObjects) {
            gameObject.update();
            gameObject.addToCanvas();
        }
    }

    /**
     * Adapts the position of all game objects.
     * @param adaptX Adaption on the x-coordinate.
     * @param adaptY Adaption on the y-coordinate.
     */
    public void moveWorld(double adaptX, double adaptY){
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getClass() != ScoreBoard.class
                    && gameObject.getClass() != Chopper.class
                    && gameObject.getClass() != Ground.class
                    && gameObject.getClass() != Background.class
                    && gameObject.getClass() != FixedStar.class
            ) {
                gameObject.adaptPosition(adaptX, adaptY);
            }
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
     * Getter method for the LinkedList tankShots.
     * @return tankshots
     */
    public LinkedList<TankShot> getTankShots() {
        return tankShots;
    }

    /**
     * Getter method for the LinkedList stars.
     * @return stars
     */
    public LinkedList<MovingStar> getMovingStars() {
        return movingStars;
    }

    public Barracks getBarracks() {
        return barracks;
    }
}
