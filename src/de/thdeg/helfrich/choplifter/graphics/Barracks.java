package de.thdeg.helfrich.choplifter.graphics;

import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

/**
 * Represents a Barracks in the game.
 */
public class Barracks extends GameObject{

    private final static String BARRACKS_CLOSED =
            "                    WWWWWWWWWW                    \n" +
                    "                  WWWWWWWWWWWWWW                  \n" +
                    "    KKKKK       WWWWWLLLLLLLLWWWWW                \n" +
                    "    KKKKK     WWWWWSSLLLLLLLLSSWWWWW              \n" +
                    "    KKKKK   WWWWWSSSSLLLLLLLLSSSSWWWWW            \n" +
                    "      KKK WWWWWSSSSSSLLLLLLLLSSSSSSWWWWW          \n" +
                    "      KKWWWWWSSSSSSSSLLLLLLLLSSSSSSSSWWWWW        \n" +
                    "      WWWWWSSSSSSSSSSLLLLLLLLSSSSSSSSSSWWWWW      \n" +
                    "    WWWWWSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSWWWWW    \n" +
                    "  WWWWWSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSWWWWW  \n" +
                    " WWWWSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSWWWW \n" +
                    " WWSSSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSSSWW \n" +
                    " SSSSSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSSSSSWWWWWWWWWWWWWWWWSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSSSWWWSWWWWWWLLWWWWWWSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSWWWSWSSWWWWLLLLWWWWSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSWWWSWSWSSSWWLLLLLLWWSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSWWWSWSWSWSSSWWLLLLLLWWSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSWWWSWSWSWSWSSSWWLLLLLLWWSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSWSWSWSWSWSWSSSWWLLLLLLWWSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSWSWSWSWSWSWSSWWWWLLLLWWWWSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSWSWSWSWSWSWSWWWWWWLLWWWWWWSSSSSSSSSSSSSSSSS \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW ";

    private final static String BARRACKS_ONFIRE =
            "                    WWWWWWWWWW                    \n" +
                    "                  WWWWWWWWWWWWWW                  \n" +
                    "    KKKKK       WWWWWLLLLLLLLWWWWW                \n" +
                    "    KKKKK     WWWWWSSLLLLLLLLSSWWWWW              \n" +
                    "    KKKKK   WWWWWSSSSLLLLLLLLSSSSWWWWW            \n" +
                    "      KKK WWWWWSSSSSSLLLLLLLLSSSSSSWWWWW          \n" +
                    "      KKWWWWWSSSSSSSSLLLLLLLLSSSSSSSSWWWWW        \n" +
                    "      WWWWWSSSSSSSSSSLLLLLLLLSSSSSSSSSSWWWWW      \n" +
                    "    WWWWWSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSWWWWW    \n" +
                    "  WWWWWSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSWWWWW  \n" +
                    " WWWWSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSWWWW \n" +
                    " WWSSSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSSSWW \n" +
                    " SSSSSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSSSSSWWWWWWWWWWWWWWWWSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSSSWWWSWWWWWWLLWWWWWWSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSSSWWWSWSSWWWWLLLLWWWWSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSWWWSWSWSSSWWLLLLLLWWSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSWWWSWSWSWSSSWWLLLLLLWWSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSWWWSWSWSWSWSSSWWLLLLLLWWSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSWSWSWSWSWSWSSSWWLLLLLLWWSSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSWSWSWSWSWSWSSWWWWLLLLWWWWSSSSSSSSSSSSSSSSSS \n" +
                    " SSSSSWSWSWSWSWSWSWWWWWWLLWWWWWWSSSSSSSSSSSSSSSSS \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW ";

    private boolean closed;
    private int takenDamage;
    private boolean destroyed;
    private int hostagesInside;

    /**
     * Creates a new Barracks.
     * @param gameView GameView to show the Barracks on.
     */
    public Barracks(GameView gameView) {
        super(gameView);
        super.gameView = gameView;
        super.position = new Position(600, 400);
        super.size=1.85;
        super.width = (int) (40 * size);
        super.height = (int) (25 * size);
        super.rotation = 0;
        this.closed = true;
        this.destroyed = false;
        this.hostagesInside = 16;
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('L', Color.BLACK);
        gameView.setColorForBlockImage('K', new Color(94, 55, 40));
        gameView.setColorForBlockImage('S', new Color(104, 58, 183));
    }

    /**
     * Draws the Barracks to the canvas.
     */
    @Override
    public void addToCanvas() {
        if (destroyed == false) {
            gameView.addBlockImageToCanvas(BARRACKS_CLOSED, position.x, position.y, size, rotation);
        } else {
            gameView.addBlockImageToCanvas(BARRACKS_ONFIRE, position.x, position.y, size, rotation);
        }
    }

    @Override
    public void updatePosition(){

    }

    private int getHostagesInside() {
        return hostagesInside;
    }

    private boolean isClosed() {
        return closed;
    }

    private boolean isDestroyed() {
        return destroyed;
    }

    private void takeDamage () {

    }

    /**
     * Shows a summary of the core information of Barracks.
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Barracks: (" + "position=" + position + ")";
    }
}
