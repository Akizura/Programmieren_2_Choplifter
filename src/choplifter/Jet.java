package choplifter;

import javax.swing.*;
import java.awt.*;

/** Represents a Jet in the game.*/
public class Jet {

    private final static String Jet =
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

    private final GameView gameView;
    private final double size;
    private final double width;
    private final double height;

    public double speedInPixel;
    private double rotation;
    private int bullets;
    private int takenDamage;
    private boolean destroyed;
    Position position;


    Jet(GameView gameView) {
        this.gameView = gameView;
        this.destroyed = false;
        this.speedInPixel = 1;
        this.position = new Position(48, 300);
        this.rotation = 0;
        this.size = 2;
        this.width = (int) (48 * size);
        this.height = (int) (19 * size);
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

    public void addToCanvas() {
        gameView.addBlockImageToCanvas(Jet, position.x, position.y, size, rotation);
    }

    void updatePosition() {
        do { position.right(speedInPixel); }
        while (position.x >= 960-width);
        do { position.left(speedInPixel);}
        while (position.x > 0+width);
    }

    void shoot() {

    }

    void takeDamage() {

    }

    @Override
    public String toString() {
        return "Jet: (" + "position=" + position + ")";
    }
}
