package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Background;

import java.awt.*;

/**
 * Represents the scoreboard in the game.
 */
public class ScoreBoard extends Background {

    private final static String RUE =
            "      W      \n" +
            "     WWW     \n" +
            "    WWWWW    \n" +
            "   WWWWWWW   \n" +
            "  WWWWWWWWW  \n" +
            " WWWWWWWWWWW \n" +
            "WWWWWWWWWWWWW\n" +
            " WWWWWWWWWWW \n" +
            "  WWWWWWWWW  \n" +
            "   WWWWWWW   \n" +
            "    WWWWW    \n" +
            "     WWW     \n" +
            "      W      \n";

    private final static String HEART =
            "  WW     WW  \n" +
            " WWWW   WWWW \n" +
            "WWWWWW WWWWWW\n" +
            "WWWWWW WWWWWW\n" +
            "WWWWWWWWWWWWW\n" +
            " WWWWWWWWWWW \n" +
            " WWWWWWWWWWW \n" +
            "  WWWWWWWWW  \n" +
            "   WWWWWWW   \n" +
            "    WWWWW    \n" +
            "     WWW     \n" +
            "      W      \n";


    private final static String SPADE ="      W      \n" +
            "     WWW     \n" +
            "    WWWWW    \n" +
            "   WWWWWWW   \n" +
            "  WWWWWWWWW  \n" +
            " WWWWWWWWWWW \n" +
            "WWWWWWWWWWWWW\n" +
            "WWWWWWWWWWWWW\n" +
            " WWWWWWWWWWW \n" +
            "    WWWWW    \n" +
            "   WWWWWWW   \n" +
            "  WWWWWWWWW  \n";

    private int deadHostages;
    private int passengersInHelicopter;
    private int hostagesRescued;

    /**
     * Creates a new scoreboard.
     *
     * @param gameView Window to show scoreboard on.
     */
    public ScoreBoard(GameView gameView) {
        super(gameView);
        this.deadHostages = 0;
        this.passengersInHelicopter = 0;
        this.hostagesRescued = 0;
        this.size = 31;
    }

    @Override
    public void updateStatus() {

    }

    @Override
    public void addToCanvas() {
        //graphics of the scoreboard
        gameView.addBlockImageToCanvas(SPADE, 210, 30, 1.7, 0);
        gameView.addBlockImageToCanvas(RUE, 450, 30, 1.7, 0);
        /*gameView.addPolygonToCanvas(new double[]{460, 450, 460, 470}, new double[]{30, 40, 50, 40}, 0, true, Color.WHITE);*/
        gameView.addBlockImageToCanvas(HEART, 685, 30, 1.75, 0);

        gameView.addRectangleToCanvas(50, 30, 150, 20, 1, true, new Color(118, 66, 43));
        gameView.addRectangleToCanvas(290, 30, 150, 20, 1, true, new Color(118, 66, 43));
        gameView.addRectangleToCanvas(525, 30, 150, 20, 1, true, new Color(118, 66, 43));
        gameView.addRectangleToCanvas(760, 30, 150, 20, 1, true, new Color(118, 66, 43));

        gameView.addLineToCanvas(50.0, 20.0, 910.0, 20.0, 3, Color.YELLOW);
        gameView.addLineToCanvas(50.0, 63.0, 910.0, 63.0, 3, Color.YELLOW);
        gameView.addPolyLineToCanvas(new double[]{50.0, 35.0, 50.0}, new double[]{20.0, 41.5, 63.0}, 3, Color.YELLOW);
        gameView.addPolyLineToCanvas(new double[]{910.0, 925.0, 910.0}, new double[]{20.0, 41.5, 63.0}, 3, Color.YELLOW);

        //changing information of the scoreboard
        gameView.addTextToCanvas(String.valueOf(deadHostages), 230, 25, size, Color.WHITE, rotation);
        gameView.addTextToCanvas(String.valueOf(passengersInHelicopter), 470, 25, size, Color.WHITE, rotation);
        gameView.addTextToCanvas(String.valueOf(hostagesRescued), 705, 25, size, Color.WHITE, rotation);
    }
}
