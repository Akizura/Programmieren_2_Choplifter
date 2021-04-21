package de.thdeg.helfrich.choplifter.game.managers;

import de.thdeg.helfrich.choplifter.gameobjects.*;
import de.thdeg.helfrich.choplifter.gameview.GameView;

public class GameObjectManager {

    private final GameView gameView;
    private final Jet jet;
    private final Drone drone;
    private final Tank tank;
    private final Barracks barracks;
    private final Hostage hostage;
    private final Base base;
    private final Chopper chopper;

    public GameObjectManager(GameView gameView) {
        this.gameView = new GameView();
        this.jet = new Jet(this.gameView);
        this.drone = new Drone(this.gameView);
        this.tank = new Tank(this.gameView);
        this.barracks = new Barracks(this.gameView);
        this.hostage = new Hostage(this.gameView);
        this.chopper = new Chopper(this.gameView);
        this.base = new Base(this.gameView);
    }
        public void updateGameObjects(){

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

    public Chopper getChopper() {
        return chopper;
    }
}
