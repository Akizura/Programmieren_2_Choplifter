package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

/**
 * Represents a Base in the game.
 */
public class Base extends Building {

    private final static String BASE1 =
                    "                                      K bb    bb    \n" +
                    "                                      Kibbi  ibbi i \n" +
                    "                                      KibbiIIibbiIi \n" +
                    "                                      KibbiIIibbiIi \n" +
                    "                                      KibbiIIibbiIi \n" +
                    "                                      KibbiIIibbiIi \n" +
                    "                                      KibbiIIibbiIi \n" +
                    "                                      Ki  iIIi  iIi \n" +
                    "                                      K    I    I  \n" +
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

    private final static String BASE2 =
                    "                                      K    bbb    b \n" +
                    "                                      Ki  bbbbi  bb \n" +
                    "                                      KiIibbbbiIibb \n" +
                    "                                      KiIibbbbiIibb \n" +
                    "                                      KiIibbbbiIibb \n" +
                    "                                      KiIibbbbiIibb \n" +
                    "                                      KiIibbbbiIibb \n" +
                    "                                      KiIi    iIi   \n" +
                    "                                      K I      I    \n" +
                    "                                      K             \n" +
                    "                                      K             \n" +
                    "                                      K             \n" +
                    "                                      K             \n" +
                    "   WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW    \n" +
                    "  WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW   \n" +
                    " KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK  \n" +
                    " KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK  \n" +
                    " KKKWWWWWWWWWKWWWWWWWWWKKKKKKWWWWWWWWWKWWWWWWWWWKK  \n" +
                    " KKKLLLLLLLLKKLLLLLLLLKKLLLKKLLLLLLLLKKLLLLLLLLKKK  \n" +
                    " KKKLLLLLLLLKKLLLLLLLLKKLLLKKLLLLLLLLKKLLLLLLLLKKK  \n" +
                    " KKKLLLLLLLLKKLLLLLLLLKKLLLKKLLLLLLLLKKLLLLLLLLKKK  \n" +
                    " KKKWWWWWWWWWKWWWWWWWWWKLLLKKWWWWWWWWWKWWWWWWWWWKK  \n" +
                    " KKKKKKKKKKKKKKKKKKKKKKKLLLKKKKKKKKKKKKKKKKKKKKKKK  \n" +
                    " WWWWWWWWWWWWWWWWWWWWWWWGGGWWWWWWWWWWWWWWWWWWWWWWW  \n";

    private final static String BASE3 =
                    "                                      K bbbbbb     \n" +
                    "                                      Kbbbbbbbbbb  \n" +
                    "                                      Kbbbbbbbbbbb \n" +
                    "                                      Kbbbbbbbbbbb \n" +
                    "                                      Kbbbbbbbbbbb \n" +
                    "                                      Kbbbbbbbbbbb \n" +
                    "                                      Kbbbbbbbbbbb \n" +
                    "                                      K bbb  bbb   \n" +
                    "                                      K  b    b    \n" +
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
        gameView.setColorForBlockImage('i', new Color(23, 159, 201));
        gameView.setColorForBlockImage('I', new Color(53, 119, 196));
    }

    private void flickerFlag() {
        boolean showBlock1 = false;
        boolean showBlock2 = false;
        if (gameView.timerExpired("flickeringFlag", "Base")) {
            gameView.setTimer("flickeringFlag", "Base", 14);
            showBlock1 = !showBlock1;
        }
        if (showBlock1) {
            gameView.addBlockImageToCanvas(BASE1, position.x, position.y, size, rotation);
        }
        else {
            gameView.addBlockImageToCanvas(BASE2, position.x, position.y, size, rotation);
            }

        /*if (gameView.timerExpired("flickeringFlag", "Base")) {
            gameView.setTimer("flickeringFlag", "Base", 30);
            showBlock2 = !showBlock2;
        }
        if (showBlock2) {
            gameView.addBlockImageToCanvas(BASE2, position.x, position.y, size, rotation);
        }
        else {
            gameView.addBlockImageToCanvas(BASE1, position.x, position.y, size, rotation);
        }*/
    }

    @Override
    public void updateStatus(){

    }

    @Override
    public void addToCanvas() {
        gameView.addPolygonToCanvas(new double[]{position.x-100,position.x-150,position.x+width+55, position.x+width+5}, new double[]{GameView.HEIGHT-100, GameView.HEIGHT-100+height/5d, GameView.HEIGHT-100+height/5d, GameView.HEIGHT-100}, 0, true, new Color(122, 181, 181));
        gameView.addLineToCanvas(position.x+width+55, GameView.HEIGHT-100+height/5d-1,position.x+width+5, GameView.HEIGHT-100, 1.5, Color.WHITE);
        flickerFlag();
    }

    @Override
    public String toString() {
        return "Base: (" + "position=" + position + ")";
    }
}
