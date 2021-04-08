package de.thdeg.helfrich.choplifter.game;
import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.*;

import java.awt.Color;

/**This class manages the main game loop of the game. */
public class GameLoopManager {
    private final GameView gameView;
    private final Jet jet;
    private final Drone drone;
    private final Tank tank;
    private final Barracks barracks;
    private final Hostage hostage;

    /*
    private String rightHelicopter;
    private String leftHelicopter;
    private String frontHelicopter;
    */

    /** Creates the main loop. */
    public GameLoopManager() {
        this.gameView = new GameView();
        this.gameView.setWindowTitle("Choplifter");
        this.gameView.setStatusText("Laura Helfrich - Java Programmierung SS 2021");
        this.gameView.setWindowIcon("WordHelicopter.png");

        this.jet = new Jet(gameView);
        this.drone = new Drone(gameView);
        this.tank = new Tank(gameView);
        this.barracks = new Barracks(gameView);
        this.hostage = new Hostage(gameView);

        /**
         * BlockImage helicopter in three different perspectives
         * */
        /*
        this.rightHelicopter =
                "        W      \n" +
                "  WWWWWWWWWWWWW\n" +
                "W       W      \n" +
                " W       W     \n" +
                "  W    WWWWW   \n" +
                "  WWWWWWWWWWW  \n" +
                "  W   WWWWWLLW \n" +
                "  W   WWWWWLLLW\n" +
                "      WWWWWWWWW\n" +
                "       WWWWWWW \n" +
                "        W W    \n" +
                "       W   W  W\n" +
                "     WWWWWWWWW \n";

        this.leftHelicopter =
                        "      W        \n" +
                        "WWWWWWWWWWWWW  \n" +
                        "      W       W\n" +
                        "     W       W \n" +
                        "   WWWWW    W  \n" +
                        "  WWWWWWWWWWW  \n" +
                        " WLLWWWWW   W  \n" +
                        "WLLLWWWWW   W  \n" +
                        "WWWWWWWWW      \n" +
                        " WWWWWWW       \n" +
                        "    W W        \n" +
                        "W  W   W       \n" +
                        " WWWWWWWWW     \n";

        this.frontHelicopter =
                "       W       \n" +
                " WWWWWWWWWWWWW \n" +
                "       W       \n" +
                "       W       \n" +
                "      WWW      \n" +
                "    WWWWWWW    \n" +
                "   WWLLLLLWW   \n" +
                "   WWLLLLLWW   \n" +
                "   WWWWWWWWW   \n" +
                "    WWWWWWW    \n" +
                "     WWWWW     \n" +
                "    W     W    \n" +
                "   W       W   \n";
                */


    }
    /** Starts the main loop of the game. */
    public void startGame() {
        while(true) {
            //Represents the ground
            this.gameView.addRectangleToCanvas(0,440,960,100,5,true,Color.GRAY);

            //Updates the positions of the GameObjects
            jet.updatePosition();
            drone.updatePosition();
            tank.updatePosition();
            hostage.updatePosition();

            //Draws the GameObjects to the canvas
            jet.addToCanvas();
            drone.addToCanvas();
            tank.addToCanvas();
            barracks.addToCanvas();
            hostage.addToCanvas();

            gameView.printCanvas();
        }
        /**
         * object references
         * */
        /*//Text
        gameView.addTextToCanvas("Oben links", 0, 0, 25, Color.YELLOW, 0);
        gameView.addTextToCanvas("Unten rechts", 660, 515, 25, Color.YELLOW, 0);
        //Lines
        gameView.addLineToCanvas(0, 50, 960, 50, 5, Color.RED);
        gameView.addLineToCanvas(0, 490, 960, 490, 5, Color.RED);
        //Forms
        gameView.addRectangleToCanvas(550, 220, 400, 260, 2, false, Color.WHITE);
        gameView.addRectangleToCanvas(552, 222, 393, 253, 5, true, Color.BLACK);
        gameView.addRectangleToCanvas(552, 425, 393, 50, 5, true, Color.GRAY);
        gameView.addOvalToCanvas(0, 90, 40, 40, 5, true, Color.BLUE);
        gameView.addOvalToCanvas(200, 90, 170, 40, 13, false, Color.GREEN);
        gameView.addRectangleToCanvas(400, 70, 100, 50, 3, false, Color.YELLOW);
        gameView.addPolyLineToCanvas(new double[]{550.00, 650.00, 750.00, 850.00, 950.00}, new double[]{100.00, 150.00, 100.00, 150.00, 100.00}, 10, Color.GREEN);
        gameView.addPolygonToCanvas(new double[]{00.00, 480.00, 960.00},new double[] {200.00, 150.00, 200.00}, 5, true, Color.cyan );

        gameView.addBlockImageToCanvas(rightHelicopter, 600, 250, 5, 45);
        gameView.addBlockImageToCanvas(leftHelicopter, 700, 300, 5, 0);
        gameView.addBlockImageToCanvas(frontHelicopter, 800, 360, 5, 0);

        //Images
        gameView.addImageToCanvas("Herz.png", 200, 400, 1.3, 0);
        gameView.addImageToCanvas("Herz.png", 300, 400, 0.8, 90);
        */
    }
}
