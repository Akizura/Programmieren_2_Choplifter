package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;

import java.awt.*;

/**
 * Represents the Background in the game.
 */
public class Background extends GameObject {

    //This Mountain has a width of: 75, and a height of: 33 chars.
    private final static String MOUNTAIN =
            "                                 WW                                        \n" +
            "                                 uWW                                       \n" +
            "                                uuuWW                                      \n" +
            "                                uuuuWW                                     \n" +
            "                               uuuuuuu                                     \n" +
            "                 WWW           uuuuuuuu                                    \n" +
            "                uuuWW       WWWuuuuuuuuu                                   \n" +
            "               uuuuuuW     uuuWWuuuuuuuuu              WWWWW               \n" +
            "             WWuuuuuuuu   uuuuuWuuuuuuuuuuWWW        uuuuuuuW              \n" +
            "            uuuWuuuuuuuu uuuuuuuWuuuuuuuuuuuuW      uuuuuuuuuW             \n" +
            "           uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuW     uuuuuuuuuuW            \n" +
            "          UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU   UUUUUUUUUUUUUW           \n" +
            "       UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU UUUUUUUUUUUUUUUU          \n" +
            "      UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU         \n" +
            "     UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU        \n" +
            "    vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv     \n" +
            "   vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv   \n" +
            "  VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV  \n" +
            " xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx \n" +
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n";

    /**
     * Creates a background.
     *
     * @param gameView
     */
    public Background(GameView gameView) {
        super(gameView);
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('u', new Color(13, 50, 214));
        gameView.setColorForBlockImage('U', new Color(16, 43, 184));
        gameView.setColorForBlockImage('v', new Color(6, 32, 163));
        gameView.setColorForBlockImage('V', new Color(3, 23, 133));
        gameView.setColorForBlockImage('x', new Color(2, 18, 96));
        gameView.setColorForBlockImage('X', new Color(0, 10, 74));
    }


    @Override
    public void updateStatus(){

    }

    /**
     * Draws the background to the canvas.
     */
    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(0, 440, 960, 100, 5, true, Color.GRAY);
        gameView.addBlockImageToCanvas(MOUNTAIN, 450, 420, 1, 0);
    }

    private void blinkManager() {

    }

    @Override
    public String toString() {
        return "Background: (" + "position= " + position + ")";
    }

}
