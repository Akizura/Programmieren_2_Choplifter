package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

/**
 * Represents a Base in the game.
 */
public class Base extends Building {

    private final static String BASE =
                    "                                      K gg   bb    \n" +
                    "                                      Kgggg bbbb b \n" +
                    "                                      KggggWbbbgbb \n" +
                    "                                      KgggbWbbgbbb \n" +
                    "                                      KggbWbWgbbbb \n" +
                    "                                      KgbWbWbWgbbb \n" +
                    "                                      KbWbWbWbWgbb \n" +
                    "                                      KW  bWb  Wgg \n" +
                    "                                      K    b    W  \n" +
                    "                                      K            \n" +
                    "                                      K            \n" +
                    "                                      K            \n" +
                    "                                      K            \n" +
                    "   WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW   \n" +
                    "  WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW  \n" +
                    " KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK \n" +
                    " KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK \n" +
                    " KKKWWWWWWWWWKWWWWWWWWWKKKKKKWWWWWWWWWKWWWWWWWWWKK \n" +
                    " KKKLLLLLLLLKKLLLLLLLLKKLLLKKLLLLLLLLKKLLLLLLLLKKK \n" +
                    " KKKLLLLLLLLKKLLLLLLLLKKLLLKKLLLLLLLLKKLLLLLLLLKKK \n" +
                    " KKKLLLLLLLLKKLLLLLLLLKKLLLKKLLLLLLLLKKLLLLLLLLKKK \n" +
                    " KKKWWWWWWWWWKWWWWWWWWWKLLLKKWWWWWWWWWKWWWWWWWWWKK \n" +
                    " KKKKKKKKKKKKKKKKKKKKKKKLLLKKKKKKKKKKKKKKKKKKKKKKK \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWGGGWWWWWWWWWWWWWWWWWWWWWWW \n";

    private int hostagesInside;

    /**
     * Creates a new base.
     *
     * @param gameView Window to show the base on.
     */
    public Base(GameView gameView) {
        super(gameView);
        super.position = new Position(700, 390);
        super.size = 2.5;
        super.width = (int) (51 * size);
        super.height = (int) (35 * size);
        super.rotation = 0;
        this.hostagesInside = 0;
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('L', Color.BLACK);
        gameView.setColorForBlockImage('G', Color.GRAY);
        gameView.setColorForBlockImage('K', new Color(94, 55, 40));
        gameView.setColorForBlockImage('b', new Color(0, 178, 212));
        gameView.setColorForBlockImage('g', new Color(29, 233, 182));
    }

    @Override
    public void updateStatus(){

    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(BASE, position.x, position.y, size, rotation);
    }

    @Override
    public String toString() {
        return "Base: (" + "position=" + position + ")";
    }
}
