package de.thdeg.helfrich.choplifter.game.managers;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.game.managers.GameObjectManager;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.*;

import java.util.LinkedList;

/**
 * This class manages the procedure of the game.
 */
public class GamePlayManager {

    private GameView gameView;
    private GameObjectManager gameObjectManager;
    private boolean listHasBeenDeleted;
    private boolean tankListHasBeenDeleted;
    private boolean droneListHasBeenDeleted;

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
    }

    /**
     * This method controls the whole game play.
     */
    public void updateGamePlay() {
        spawnAndDestroyJets();
        spawnAndDestroyTanks();
        spawnAndDestroyDrones();
    }

    private void spawnAndDestroyJets(){
        LinkedList<Jet> jets = gameObjectManager.getJets();
        if (gameObjectManager.getJets().size() > 30){
            gameObjectManager.getJets().removeFirst();
            System.out.println("removedFirstJet");
        }

        if(gameView.timerExpired("spawnJet", "GamePlayManager")){
            gameView.setTimer("spawnJet", "GamePlayManager", 1000);
            Jet jet = new Jet(gameView);
            jet.setGamePlayManager(this);
            jets.add(jet);
            System.out.println("spawnedJet");
        }

        if (gameView.timerExpired("destroyJet", "GamePlayManager")){
            gameView.setTimer("destroyJet", "GamePlayManager", 5000);
            if(!jets.isEmpty()){
                jets.remove(0);
                System.out.println("removedJet");
            }
        }

        if((listHasBeenDeleted == false) && gameView.getGameTimeInMilliseconds() > 10_000){
            jets.clear();
            listHasBeenDeleted = true;
            System.out.println("cleared");
        }
    }

    private void spawnAndDestroyTanks(){
        LinkedList<Tank> tanks = gameObjectManager.getTanks();
        if (gameObjectManager.getTanks().size() > 30){
            gameObjectManager.getTanks().removeFirst();
        }

        if(gameView.timerExpired("spawnTank", "GamePlayManager")){
            gameView.setTimer("spawnTank", "GamePlayManager", 1000);
            Tank tank = new Tank(gameView);
            tank.setGamePlayManager(this);
            tanks.add(tank);
        }

        if (gameView.timerExpired("destroyTank", "GamePlayManager")){
            gameView.setTimer("destroyTank", "GamePlayManager", 5000);
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
        LinkedList<Drone> drones = gameObjectManager.getDrones();
        if (gameObjectManager.getDrones().size() > 30){
            gameObjectManager.getDrones().removeFirst();
        }

        if(gameView.timerExpired("spawnDrone", "GamePlayManager")){
            gameView.setTimer("spawnDrone", "GamePlayManager", 2000);
            Drone drone = new Drone(gameView);
            drone.setGamePlayManager(this);
            drones.add(drone);
        }

        if (gameView.timerExpired("destroyDrone", "GamePlayManager")){
            gameView.setTimer("destroyDrone", "GamePlayManager", 5000);
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
        ChopperShot chopperShot = new ChopperShot(gameView);
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
        JetShot jetShot1 = new JetShot(gameView);
        jetShot1.getPosition().x = startPosition.x;
        jetShot1.getPosition().y = startPosition.y + 19;
        jetShot1.setGamePlayManager(this);
        gameObjectManager.getJetShots().add(jetShot1);

        JetShot jetShot2 = new JetShot(gameView);
        jetShot2.getPosition().x = startPosition.x + 50;
        jetShot2.getPosition().y = startPosition.y + 19;
        jetShot2.setGamePlayManager(this);
        gameObjectManager.getJetShots().add(jetShot2);
    }

    /**
     * Adds a shot, so it will be displayed on the window.
     *
     * @param startPosition The position to spawn the shot from.
     */
    public void shootTankShot(Position startPosition) {
        TankShot tankShot = new TankShot(gameView);
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

}
