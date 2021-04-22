package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Background;

import java.awt.*;

/**
 * Represents the scoreboard in the game.
 */
public class ScoreBoard extends Background {

    private int deadHostages;
    private int passengersInHelicopter;
    private int hostagesRescued;

    /**
     * Creates a new scoreboard.
     * @param gameView Window to show scoreboard on.
     */
    public ScoreBoard(GameView gameView){
        super(gameView);
        this.deadHostages = 0;
        this.passengersInHelicopter = 0;
        this.hostagesRescued = 0;
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas(String.valueOf(deadHostages), 100, 100, size, Color.WHITE, rotation);
        gameView.addTextToCanvas(String.valueOf(passengersInHelicopter), 200, 100, size, Color.WHITE, rotation);
        gameView.addTextToCanvas(String.valueOf(hostagesRescued), 300, 100, size, Color.WHITE, rotation);
    }
}
