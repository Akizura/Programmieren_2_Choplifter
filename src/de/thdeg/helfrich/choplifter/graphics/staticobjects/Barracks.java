package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

/**
 * Represents a Barracks in the game.
 */
public class Barracks extends Building {

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

    private final static String BARRACKS_ONFIRE1 =
                    "                    WWWWWWWWWW                    \n" +
                    "                  WWWWWWWWWWWWWW                  \n" +
                    "    KKKKK       WWWWWLLLLYLLLWWWWW                \n" +
                    "    KKKKK     WWWWWSSLLLLLLLLSSWWWWW              \n" +
                    "    KKKKK   WWWWWSSSSLLLLLLLLSSSSWWWWW            \n" +
                    "      KKK WWWWWSSSSSSLLLLLYLLSSSSSSWWWWW          \n" +
                    "      KKWWWWWSSSSYSSSLLLLLLLLSSSSSSSSWWWWW        \n" +
                    "      WWWWWSSSSSSSSSSLLLLLLLLSSSSSSSSSSWWWWW      \n" +
                    "    WWWWWSSSSSSSSSSSSLLYLLLLLSSSSSSSSSSSSWWWWW    \n" +
                    "  WWWWWSSSSSSSSSSSSSSLLLLLLLSSSSSSYSSSSSSSWWWWW  \n" +
                    " WWWWSSSSSSSLLLLSSSSSLLLLYLLLSSSSSSSSSSSSSSSSWWWW \n" +
                    " WWSSSSSSSSSLLLLLLSSSLLLLLLLLSSSSSSLLYLSSSSSSSSWW \n" +
                    " SSSSSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSS \n" +
                    " SSSSSSLLLLLLLLYLLLLLLLLLLLLLqLLLLYLLSSSSSSSSSSSS \n" +
                    " SSSSSSLLLLLLLLLLLLLLLLLLLLLqqqLLLSSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSLLYLLLLLLLqLLLLLLLRqYqRLLLLLLLLLSSSSSSSS \n" +
                    " SSSSSSSSSLLLLLLLLqqqLLLYLLRqYqRLLLLYLLLLSSSSSSSS \n" +
                    " SSSSYSSSSSSSLLLLLRqYqRLLLLLLqKqLLLLLSSSSSSSSSSSS \n" +
                    " SSSSSSSSSLLLLLLLRqYqRLLLLLLKKKLLLLSSSSSSSSSSYSSS \n" +
                    " SSSSSSSLLLLLYLLRqYYYqRLLLLKKKKKLLLLLLLSSSSSSSSSS \n" +
                    " SSSSSSSLLLLLLLLRqYYYqRLLLLLLLLLLLLLLLLLLLSSSSSSS \n" +
                    " SSSSSSSSSSSSLLLLRqKqRLLLLYLLLLLLLLLLLLLLLSSSSSSS \n" +
                    " SSSSSSSSSSLLLLLLLKKKLLLLLLLLLLYLLLLLLSSSSSSSSSSS \n" +
                    " SSSSSSSSSLLLLLLLKKKKKLLLLLLLLLLLSSSSSSSSSSSSSSSS \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW ";

    private final static String BARRACKS_ONFIRE2 =
            "                    WWWWWWWWWW                    \n" +
                    "                  WWWWWWWWWWWWWW                  \n" +
                    "    KKKKK       WWWWWLLLLLLLLWWWWW                \n" +
                    "    KKKKK     WWWWWSSLLLLLLLLSSWWWWW              \n" +
                    "    KKKKK   WWWWWSSSSLLLLLLLLSSSSWWWWW            \n" +
                    "      KKK WWWWWSSSSSSLLLLLLLLSSSSSSWWWWW          \n" +
                    "      KKWWWWWSSSSYSSSLLLLLLLLSSSSSSSSWWWWW        \n" +
                    "      WWWWWSSSSSSSSSSLLLLLLLLSSSSSSSSSSWWWWW      \n" +
                    "    WWWWWSSSSSSSSSSSSLLLLLLLLSSSSSSSSSSSSWWWWW    \n" +
                    "  WWWWWSSSSSSSSSSSSSSLLLLLLLSSSSSSSSSSSSSSWWWWW   \n" +
                    " WWWWSSSSSSSLLLLSSSSSLLLLLLLLSSSSSSSSSSSSSSSSWWWW \n" +
                    " WWSSSSSSSSSLLLLLLSSSLLLLLLLLSSSSSSLLLLSSSSSSSSWW \n" +
                    " SSSSSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSS \n" +
                    " SSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSSSS \n" +
                    " SSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSSSSSS \n" +
                    " SSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSS \n" +
                    " SSSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSS \n" +
                    " SSSSSSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSSSSS \n" +
                    " SSSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSSSSSS \n" +
                    " SSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSS \n" +
                    " SSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSS \n" +
                    " SSSSSSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSS \n" +
                    " SSSSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSSS \n" +
                    " SSSSSSSSSLLLLLLLLLLLLLLLLLLLLLLLSSSSSSSSSSSSSSSS \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW ";

    private boolean closed;
    private int takenDamage;
    private boolean destroyed;
    private int hostagesInside;

    /**
     * Creates a new Barracks.
     *
     * @param gameView GameView to show the Barracks on.
     */
    public Barracks(GameView gameView) {
        super(gameView);
        super.gameView = gameView;
        super.position = new Position(200, 410);
        super.size = 1.5;
        super.width = (int) (48 * size);
        super.height = (int) (25 * size);
        super.rotation = 0;
        this.closed = true;
        this.destroyed = true;
        this.hostagesInside = 16;
        super.hitBox = new Rectangle((int) position.x, (int) position.y, width, height-13);
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('L', Color.BLACK);
        gameView.setColorForBlockImage('R', Color.RED);
        gameView.setColorForBlockImage('Y', Color.YELLOW);
        gameView.setColorForBlockImage('q', new Color(179, 53, 25));
        gameView.setColorForBlockImage('K', new Color(94, 55, 40));
        gameView.setColorForBlockImage('S', new Color(104, 58, 183));
    }

    @Override
    protected void updateHitBoxPosition() {
        hitBox = new Rectangle((int) position.x+2, (int) position.y+14, hitBox.width, hitBox.height);
    }

    @Override
    protected void reactToCollision(CollidableGameObject otherObject) {

    }

    /**
     * Draws the Barracks to the canvas.
     */
    @Override
    public void addToCanvas() {
        if (destroyed == false) {
            gameView.addBlockImageToCanvas(BARRACKS_CLOSED, position.x, position.y, size, rotation);
        } else {
           onFire();
        }
        gameView.addRectangleToCanvas(hitBox.x, hitBox.y, hitBox.width, hitBox.height, 1, false, Color.RED);
    }

    private void onFire(){
        boolean showBlock1 = false;
        if (gameView.timerExpired("onFire", "Barracks")) {
            gameView.setTimer("onFire", "Barracks", 14);
            showBlock1 = !showBlock1;
        }
        if (showBlock1) {
            gameView.addBlockImageToCanvas(BARRACKS_ONFIRE1, position.x, position.y, size, rotation);
        }
        else {
            gameView.addBlockImageToCanvas(BARRACKS_ONFIRE2, position.x, position.y, size, rotation);
        }
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

    public boolean getDestroyed(){return destroyed;}

    private void takeDamage() {

    }

    @Override
    public void updateStatus(){

    }

    /**
     * Shows a summary of the core information of Barracks.
     *
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Barracks: (" + "position=" + position + ")";
    }
}
