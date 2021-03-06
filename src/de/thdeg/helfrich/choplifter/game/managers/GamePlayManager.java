package de.thdeg.helfrich.choplifter.game.managers;

import de.thdeg.helfrich.choplifter.game.utilities.Level;
import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.*;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.MovingStar;
import de.thdeg.helfrich.choplifter.game.utilities.Player;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class manages the procedure of the game.
 */
public class GamePlayManager {

    private GameView gameView;
    private GameObjectManager gameObjectManager;
    private boolean jetListHasBeenDeleted;
    private boolean tankListHasBeenDeleted;
    private boolean droneListHasBeenDeleted;
    private boolean movingStarListHasBeenDeleted;
    private Player player;

    /**
     * Creates a new GamePlayManager.
     *
     * @param gameView          Window to show the game objects on.
     * @param gameObjectManager Connection to gameObjectManager.
     */
    public GamePlayManager(GameView gameView, GameObjectManager gameObjectManager) {
        this.gameView = gameView;
        this.gameObjectManager = gameObjectManager;
        gameObjectManager.getChopper().setGamePlayManager(this);
        this.player = new Player();
        this.player.level = new Level("First Sortie", 10);
        player.lives = Player.MAXIMUM_NUMBER_OF_LIVES;
        int number = gameView.playSound("Wobbel1.wav", true);
    }

    /**
     * Moves the World to the right.
     * @param speedInPixel Speed to move the World
     */
    public void chopperMovingLeft(double speedInPixel){
        gameObjectManager.moveWorld(speedInPixel, 0);
    }

    /**
     * Moves the World to the left.
     * @param speedInPixel Speed to move the World
     */
    public void chopperMovingRight(double speedInPixel){
        gameObjectManager.moveWorld(-speedInPixel, 0);
    }

    /**
     * This method controls the whole game play.
     */
    public void updateGamePlay() {
        spawnAndDestroyJets();
        spawnAndDestroyTanks();
        spawnAndDestroyDrones();
        spawnAndDestroyStars();
        spawnHostages();
        /*chopperCollision();*/
    }


    /*private void chopperCollision(){
        gameObjectManager.getChopper();
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.addAll(gameObjectManager.getHostages());
    }*/

    private void spawnHostages() {
        LinkedList<Hostage> hostages = gameObjectManager.getHostages();
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.add(gameObjectManager.getChopper());
        collidableGameObjects.add(gameObjectManager.getBase());

        boolean barracksEmpty = false;
        if (gameObjectManager.getHostages().size() == 16){
            barracksEmpty = true;
        }

        if (gameObjectManager.getBarracks().getDestroyed() == true && barracksEmpty == false) {
            if (gameView.timerExpired("spawnHostage", "GamePlayManager")) {
                gameView.setTimer("spawnHostage", "GamePlayManager", 3000);
                Hostage hostage = new Hostage(gameView);
                hostage.setGamePlayManager(this);
                hostages.add(hostage);
            }
        }
    }

    private void spawnAndDestroyStars(){
        LinkedList<MovingStar> movingStars = gameObjectManager.getMovingStars();
        if (gameObjectManager.getMovingStars().size() > 50){
            gameObjectManager.getMovingStars().removeFirst();
        }

        if(gameView.timerExpired("spawnStar", "GamePlayManager")){
            gameView.setTimer("spawnStar", "GamePlayManager", 300);
            MovingStar movingStar = new MovingStar(gameView);
            movingStar.setGamePlayManager(this);
            movingStars.add(movingStar);
        }

        if (gameView.timerExpired("destroyStar", "GamePlayManager")){
            gameView.setTimer("destroyStar", "GamePlayManager", 1000);
            if(!movingStars.isEmpty()){
                movingStars.remove(0);
            }
        }

        if((movingStarListHasBeenDeleted == false) && gameView.getGameTimeInMilliseconds() > 10_000){
            movingStars.clear();
            movingStarListHasBeenDeleted = true;
        }
    }

    private void spawnAndDestroyJets(){
        LinkedList<Jet> jets = gameObjectManager.getJets();
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.add(gameObjectManager.getChopper());
        if (gameObjectManager.getJets().size() > 5){
            gameObjectManager.getJets().removeFirst();
        }

        if(gameView.timerExpired("spawnJet", "GamePlayManager")){
            gameView.setTimer("spawnJet", "GamePlayManager", 3000);
            Jet jet = new Jet(gameView, gameObjectManager.getChopper(), collidableGameObjects);
            jet.setGamePlayManager(this);
            jets.add(jet);
        }

        if (gameView.timerExpired("destroyJet", "GamePlayManager")){
            gameView.setTimer("destroyJet", "GamePlayManager", 7000);
            if(!jets.isEmpty()){
                jets.remove(0);
            }
        }

        if((jetListHasBeenDeleted == false) && gameView.getGameTimeInMilliseconds() > 10_000){
            jets.clear();
            jetListHasBeenDeleted = true;
        }
    }

    private void spawnAndDestroyTanks(){
        LinkedList<Tank> tanks = gameObjectManager.getTanks();
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.add(gameObjectManager.getChopper());
        if (gameObjectManager.getTanks().size() > 5){
            gameObjectManager.getTanks().removeFirst();
        }

        if(gameView.timerExpired("spawnTank", "GamePlayManager")){
            gameView.setTimer("spawnTank", "GamePlayManager", 3000);
            Tank tank = new Tank(gameView, collidableGameObjects);
            tank.setGamePlayManager(this);
            tanks.add(tank);
        }

        if (gameView.timerExpired("destroyTank", "GamePlayManager")){
            gameView.setTimer("destroyTank", "GamePlayManager", 7000);
            if(!tanks.isEmpty()){
                tanks.remove(0);
            }
        }

        if((tankListHasBeenDeleted == false) && gameView.getGameTimeInMilliseconds() > 10_000){
            tanks.clear();
            tankListHasBeenDeleted = true;
        }
    }

    private void spawnAndDestroyDrones(){
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.add(gameObjectManager.getChopper());
        // add base to collide with?
        LinkedList<Drone> drones = gameObjectManager.getDrones();
        if (gameObjectManager.getDrones().size() > 5){
            gameObjectManager.getDrones().removeFirst();
        }

        if(gameView.timerExpired("spawnDrone", "GamePlayManager")){
            gameView.setTimer("spawnDrone", "GamePlayManager", 5000);
            Drone drone = new Drone(gameView, gameObjectManager.getChopper(), collidableGameObjects);
            drone.setGamePlayManager(this);
            drones.add(drone);
        }

        if (gameView.timerExpired("destroyDrone", "GamePlayManager")){
            gameView.setTimer("destroyDrone", "GamePlayManager", 8000);
            if(!drones.isEmpty()){
                drones.remove(0);
            }
        }

        if((droneListHasBeenDeleted == false) && gameView.getGameTimeInMilliseconds() > 10_000){
            drones.clear();
            droneListHasBeenDeleted = true;
        }
    }

    /**
     * Adds a shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootChopperShot(Position startPosition){
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.addAll(gameObjectManager.getHostages());
        collidableGameObjects.addAll(gameObjectManager.getJets());
        collidableGameObjects.addAll(gameObjectManager.getTanks());
        collidableGameObjects.addAll(gameObjectManager.getDrones());
        ChopperShot chopperShot = new ChopperShot(gameView, gameObjectManager.getChopper(), gameObjectManager,collidableGameObjects);
        chopperShot.getPosition().x = startPosition.x;
        chopperShot.getPosition().y = startPosition.y;
        chopperShot.setGamePlayManager(this);
        gameObjectManager.getChopperShots().add(chopperShot);
    }

    /**
     * Adds a shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootJetShot(Position startPosition){
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.addAll(gameObjectManager.getHostages());
        collidableGameObjects.add(gameObjectManager.getChopper());
        JetShot jetShot1 = new JetShot(gameView, collidableGameObjects);
        jetShot1.getPosition().x = startPosition.x;
        jetShot1.getPosition().y = startPosition.y+35;
        jetShot1.setGamePlayManager(this);
        gameObjectManager.getJetShots().add(jetShot1);

        JetShot jetShot2 = new JetShot(gameView, collidableGameObjects);
        jetShot2.getPosition().x = startPosition.x;
        jetShot2.getPosition().y = startPosition.y;
        jetShot2.setGamePlayManager(this);
        gameObjectManager.getJetShots().add(jetShot2);
    }

    /**
     * Adds a shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootTankShot(Position startPosition) {
        ArrayList<CollidableGameObject> collidableGameObjects = new ArrayList<>();
        collidableGameObjects.addAll(gameObjectManager.getHostages());
        collidableGameObjects.add(gameObjectManager.getChopper());
        TankShot tankShot = new TankShot(gameView, collidableGameObjects);
        tankShot.getPosition().x = startPosition.x;
        tankShot.getPosition().y = startPosition.y;
        tankShot.setGamePlayManager(this);
        gameObjectManager.getTankShots().add(tankShot);
    }

    /**
     * Removes a Shot from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param shot Object to be removed from the window.
     */
    public void destroy(Shot shot) {
        if (shot.getClass() == JetShot.class) {
            gameObjectManager.getJetShots().remove(shot);
        } else if (shot.getClass() == ChopperShot.class) {
            gameObjectManager.getChopperShots().remove(shot);
        } else if (shot.getClass() == TankShot.class){
            gameObjectManager.getTankShots().remove(shot);
        }
    }

    /**Removes a Hostage from the list of game objects, so it will be not be displayed on the window anymore.
     *
     * @param hostage Object to be removed from the window.
     */
    public void destroy(Hostage hostage){
        gameObjectManager.getHostages().remove(hostage);
    }

    /**
     * Removes a Jet from the list of game objects, so it will be not be displayed on the window anymore.
     * @param jet Object to be removed from the window.
     */
    public void destroy(Jet jet) {gameObjectManager.getJets().remove(jet);}

}
