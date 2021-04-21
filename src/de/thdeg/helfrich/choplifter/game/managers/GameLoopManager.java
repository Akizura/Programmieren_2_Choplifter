package de.thdeg.helfrich.choplifter.game.managers;
import de.thdeg.helfrich.choplifter.gameview.GameView;

/** This class manages the main game loop of the game. */
public class GameLoopManager {

    private final GameView gameView;
    private final InputManager inputManager;
    private final GameObjectManager gameObjectManager;
    private final GamePlayManager gamePlayManager;

    /** Creates the main loop. */
    public GameLoopManager() {
        this.gameView = new GameView();
        this.gameView.setWindowTitle("Choplifter");
        this.gameView.setStatusText("Laura Helfrich - Java Programmierung SS 2021");
        this.gameView.setWindowIcon("WordHelicopter.png");

        this.gameObjectManager = new GameObjectManager(gameView);
        this.inputManager = new InputManager(gameView, gameObjectManager.getChopper());
        this.gamePlayManager = new GamePlayManager(gameView, gameObjectManager);
    }
    /** Starts the main loop of the game. */
    public void startGame() {
        while (true) { // The "Game-Loop"
            gamePlayManager.updateGamePlay();
            inputManager.updateUserInputs();
            gameObjectManager.updateGameObjects();
            gameView.printCanvas();
        }
    }
}
