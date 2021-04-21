package de.thdeg.helfrich.choplifter.game.managers;

import de.thdeg.helfrich.choplifter.gameview.GameView;

public class GamePlayManager {

    private final GameView gameView;
    private final GameObjectManager gameObjectManager;

    public GamePlayManager(GameView gameView, GameObjectManager gameObjectManager){
        this.gameView = new GameView();
        this.gameObjectManager = new GameObjectManager(gameView);
    }

    public void updateGamePlay(){

    }

}
