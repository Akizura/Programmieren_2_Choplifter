package de.thdeg.helfrich.choplifter.gameobjects;
import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

/** Represents a jet in the game.*/
public class Jet extends Shooter{

    private final static String JET_RIGHT =
            " LLLL                                           \n" +
                    " LaaLLLL                                        \n" +
                    " LaaaLAAL                                       \n" +
                    " LaaaLAAAL                                      \n" +
                    " LaaaaLAAL                                      \n" +
                    " LaaaaLLAAL                                     \n" +
                    " LaaaaaLAAAL                                    \n" +
                    " LaaaaaLLLAAL                   LLLLL           \n" +
                    " LaaaaaaaLAAAL               LLLLdddLLL         \n" +
                    "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLddddddddLL        \n" +
                    "LDDDDDDDDDDDDDDDDDDDDDDDDDDDDLLLLLddddLL        \n" +
                    "LeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeLLLdddLL       \n" +
                    "LEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEELLLLLLLL     \n" +
                    "LfffffffffffffffffffffffffffffffffffffffffL     \n" +
                    "LEEEEEEEEEEELLLLLLLLLLLLLLLLLLLEEEEEEEEEEEEEL   \n" +
                    "LeeeeeeeeeeeeLFFFFFFFFFFFFFFFLeeeeeeeeeeeeeeeeeL\n" +
                    "LDDDDDDDDDDDDDLLLLLLLLLLLLLLLDDDDDDDDDDDDDDLLLLL\n" +
                    "  LaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaLLLLL     \n" +
                    "  LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL         \n";

    private final static String JET_LEFT =
            "                                           LLLL \n" +
                    "                                        LLLLaaL \n" +
                    "                                       LAALaaaL \n" +
                    "                                      LAAALaaaL \n" +
                    "                                      LAALaaaaL \n" +
                    "                                     LAALLaaaaL \n" +
                    "                                    LAAALaaaaaL \n" +
                    "           LLLLL                   LAALLLaaaaaL \n" +
                    "         LLLdddLLLL               LAAALaaaaaaaL \n" +
                    "        LLddddddddLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
                    "        LLddddLLLLLDDDDDDDDDDDDDDDDDDDDDDDDDDDDL\n" +
                    "       LLdddLLLeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeL\n" +
                    "     LLLLLLLLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEL\n" +
                    "     LfffffffffffffffffffffffffffffffffffffffffL\n" +
                    "   LEEEEEEEEEEEEELLLLLLLLLLLLLLLLLLLEEEEEEEEEEEL\n" +
                    "LeeeeeeeeeeeeeeeeeLFFFFFFFFFFFFFFFLeeeeeeeeeeeeL\n" +
                    "LLLLLDDDDDDDDDDDDDDLLLLLLLLLLLLLLLDDDDDDDDDDDDDL\n" +
                    "     LLLLLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaL  \n" +
                    "         LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL  \n";

    private int bullets;
    private int takenDamage;
    private boolean destroyed;
    private boolean moveFromLeftToRight;

    /**
     * Creates a new Jet.
     * @param gameView GameView to show the Jet on.
     */
    public Jet(GameView gameView){
        super(gameView);
        super.gameView = gameView;
        super.position = new Position(48, 250);
        super.size = 2;
        super.width = (int) (48 * size);
        super.height = (int) (19 * size);
        super.rotation = 0;
        super.speedInPixel = 2;
        this.moveFromLeftToRight = true;
        this.destroyed = false;
        super.shotsPerSecond = 2;
        super.inRangeOfChopper = false;
        gameView.setColorForBlockImage('d', new Color(64, 195, 255));
        gameView.setColorForBlockImage('A', new Color(74, 20, 140));
        gameView.setColorForBlockImage('a', new Color(105, 27, 145));
        gameView.setColorForBlockImage('D', new Color(123, 31, 162));
        gameView.setColorForBlockImage('e', new Color(141, 36, 170));
        gameView.setColorForBlockImage('E', new Color(156, 39, 176));
        gameView.setColorForBlockImage('f', new Color(255, 190, 231));
        gameView.setColorForBlockImage('F', new Color(186, 104, 200));
        gameView.setColorForBlockImage('L', Color.BLACK);
    }

    /**
     * Draws the Jet to the canvas.
     */
    @Override
    public void addToCanvas() {
        if (moveFromLeftToRight == true) {
            gameView.addBlockImageToCanvas(JET_RIGHT, position.x, position.y, size, rotation);
        } else {
            gameView.addBlockImageToCanvas(JET_LEFT, position.x, position.y, size, rotation);
        }
    }

    /**
     * Moves the Jet.
     */
    @Override
    public void updatePosition() {
        if (moveFromLeftToRight == true & position.x < 960 - width) {
            position.right(speedInPixel);
        } else {
            moveFromLeftToRight = false;
            if (moveFromLeftToRight == false) {
                position.left(speedInPixel);
                if(position.x <= 0){
                    moveFromLeftToRight = true;
                }
            }
        }
    }

    private void shoot() {

    }

    private void takeDamage() {

    }

    /**
     * Shows a summary of the core information of Jet.
     * @return Returns the name of the class and the current position.
     */
    @Override
    public String toString() {
        return "Jet: (" + "position=" + position + ")";
    }
}
