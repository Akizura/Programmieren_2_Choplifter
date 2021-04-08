package de.thdeg.helfrich.choplifter.graphics;

import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

/**
 * Represents a hostage in the game.
 */
public class Hostage extends GameObject{

    private final static String HOSTAGE_RIGHT =
            "                         LLL          \n" +
                    "                        LWWWL         \n" +
                    "                       LWWWWWL        \n" +
                    "                      LWWWWWWWL       \n" +
                    "                      LWWWWWWWL       \n" +
                    "                      LWWWWWWWL       \n" +
                    "                       LWWWWWL        \n" +
                    "                        LWWWL         \n" +
                    "                         LLL          \n" +
                    "                                      \n" +
                    "                  LLLLLLLLL           \n" +
                    "                LLWWWWWWWWWL          \n" +
                    "              LLWWWWWWWWWWWWLL     LLL\n" +
                    "             LWWWWWLLLWWWWWWWWL   LWWL\n" +
                    "           LLWWWWLL  LWWWWWWWWL  LWWL \n" +
                    "          LWWWWLL   LWWWWWWWLWWLLWWWL \n" +
                    "         LWWWWL     LWWWWWWLWWWLWWWL  \n" +
                    "        LWWWLL     LWWWWWWL LWWWWWL   \n" +
                    "       LWWLL      LWWWWWWWL  LWWWL    \n" +
                    "        LL        LWWWWWWL    LWL     \n" +
                    "                 LWWWWWWL      L      \n" +
                    "                LWWWWWWWL             \n" +
                    "               LWWWWWWWL              \n" +
                    "              LWWWWWWWL               \n" +
                    "             LWWLWWWWL                \n" +
                    "            LWWWWLWWWL                \n" +
                    "           LWWWL  LWWWL               \n" +
                    "          LWWWL    LWWWL              \n" +
                    " LLLLLLLLLWWWL      LWWWL             \n" +
                    "LWWWWWWWWWWWL        LWWWL            \n" +
                    "LWWWWWWWWWWL          LWWWL           \n" +
                    " LLLLLLLLLL            LWWL           \n" +
                    "                       LWWL           \n" +
                    "                       LWWL           \n" +
                    "                       LWWL           \n" +
                    "                       LWWL           \n" +
                    "                       LWWL           \n" +
                    "                       LWWL           \n" +
                    "                       LWWL           \n" +
                    "                       LWWL           \n" +
                    "                       LWWL           \n" +
                    "                        LL            \n";

    private final static String HOSTAGE_LEFT =
            "          LLL                         \n" +
                    "         LWWWL                        \n" +
                    "        LWWWWWL                       \n" +
                    "       LWWWWWWWL                      \n" +
                    "       LWWWWWWWL                      \n" +
                    "       LWWWWWWWL                      \n" +
                    "        LWWWWWL                       \n" +
                    "         LWWWL                        \n" +
                    "          LLL                         \n" +
                    "                                      \n" +
                    "           LLLLLLLLL                  \n" +
                    "          LWWWWWWWWWLL                \n" +
                    "LLL     LLWWWWWWWWWWWWLL              \n" +
                    "LWWL   LWWWWWWWWLLLWWWWWL             \n" +
                    " LWWL  LWWWWWWWWL  LLWWWWLL           \n" +
                    " LWWWLLWWLWWWWWWWLL  LLWWWWL          \n" +
                    "  LWWWLWWWLWWWWWWL     LWWWWL         \n" +
                    "   LWWWWWL LWWWWWWL     LWWWLL        \n" +
                    "    LWWWL  LWWWWWWWL     LWWLL        \n" +
                    "     LWL    LWWWWWWL       LL         \n" +
                    "      L      LWWWWWWL                 \n" +
                    "             LWWWWWWWL                \n" +
                    "              LWWWWWWWL               \n" +
                    "               LWWWWWWWL              \n" +
                    "                LWWWWLWWL             \n" +
                    "                LWWWLWWWWL            \n" +
                    "               LWWWL  LWWWL           \n" +
                    "              LWWWL    LWWWL          \n" +
                    "             LWWWL      LWWWLLLLLLLLL \n" +
                    "            LWWWL        LWWWWWWWWWWWL\n" +
                    "           LWWWL          LWWWWWWWWWWL\n" +
                    "           LWWL            LLLLLLLLLL \n" +
                    "           LWWL                       \n" +
                    "           LWWL                       \n" +
                    "           LWWL                       \n" +
                    "           LWWL                       \n" +
                    "           LWWL                       \n" +
                    "           LWWL                       \n" +
                    "           LWWL                       \n" +
                    "           LWWL                       \n" +
                    "           LWWL                       \n" +
                    "            LL                       ";

    private final static String HOSTAGE_WAITING =
            "                 LLL                  \n" +
                    "                LWWWL                 \n" +
                    "               LWWWWWL                \n" +
                    "              LWWWWWWWL               \n" +
                    "              LWWWWWWWL               \n" +
                    "              LWWWWWWWL               \n" +
                    "               LWWWWWL                \n" +
                    "                LWWWL                 \n" +
                    "                 LLL                  \n" +
                    "                                      \n" +
                    "              LLLLLLLLL               \n" +
                    "             LWWWWWWWWWWL             \n" +
                    "           LLWWWWWWWWWWWWLL           \n" +
                    "          LWWWLWWWWWWWWWWWWL          \n" +
                    "        LWWWL LWWWWWWWWL LWWWL        \n" +
                    "       LWWL   LWWWWWWWWL  LWWWL       \n" +
                    "     LWWL     LWWWWWWWWL    LWWL      \n" +
                    "    LWWL       LWWWWWWL     LWWL      \n" +
                    "   LWWL        LWWWWWWL      LWWL     \n" +
                    "   LWL         LWWWWWWL      LWL      \n" +
                    "    L          LWWWWWWL       L       \n" +
                    "              LWWWWWWWWL              \n" +
                    "              LWWWWWWWWL              \n" +
                    "              LWWWWWWWWL              \n" +
                    "              LWWWLWWWWL              \n" +
                    "              LWWWLLWWWL              \n" +
                    "             LWWWL LWWWL              \n" +
                    "             LWWWL  LWWWL             \n" +
                    "            LWWWL   LWWWL             \n" +
                    "            LWWWL   LWWWL             \n" +
                    "            LWWWL   LWWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "            LWWL     LWWL             \n" +
                    "             LL       LL              ";

    private int takenDamage;
    private boolean alive;
    private boolean passenger;
    private boolean touchedByHelicopter;
    private boolean inRangeOfHelicopter;
    private boolean flyFromLeftToRight;
    private boolean waiting;

    /**
     * Creates a new Hostage
     * @param gameView GameView to show the Hostage on.
     */
    public Hostage(GameView gameView) {
        super(gameView);
        super.gameView = gameView;
        super.position = new Position(500, 430);
        super.size = 0.75;
        super.width = (int) (38 * size);
        super.height = (int) (42 * size);
        super.rotation = 0;
        super.speedInPixel = 1;
        this.flyFromLeftToRight = true;
        this.waiting = false;
        this.touchedByHelicopter = false;
        this.inRangeOfHelicopter = false;
        this.alive = true;
        this.passenger = false;
    }

    /**
     * Draws the Hostage to the canvas.
     */
    @Override
    public void addToCanvas() {
        if(flyFromLeftToRight == true) {
            gameView.addBlockImageToCanvas(HOSTAGE_RIGHT, position.x, position.y, size, rotation);
        } else {
            gameView.addBlockImageToCanvas(HOSTAGE_LEFT, position.x, position.y, size, rotation);
        }
        if(waiting == true){
            gameView.addBlockImageToCanvas(HOSTAGE_WAITING, position.x, position.y, size, rotation);
        }
    }

    /**
     * Moves the Hostage.
     */
    @Override
    public void updatePosition() {
        if (flyFromLeftToRight == true & position.x < 960 - width) {
            position.right(speedInPixel);
        } else {
            flyFromLeftToRight = false;
            if (flyFromLeftToRight == false) {
                position.left(speedInPixel);
                if(position.x <= 0){
                    flyFromLeftToRight = true;
                }
            }
        }
    }

    private void runToHelicopter(){

    }

    private void takeDamage(){

    }

    private void waitingForHelp(){

    }

    /**
     * Shows a summary of the core information of Hostage.
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Hostage: (" + "position=" + position + ")";
    }

}
