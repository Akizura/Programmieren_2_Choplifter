package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;

import java.awt.*;

public class Skyline extends Background{

    private final static String SKYLINE ="\n" +
            "      h                                           \n" +
            "      hh                                          \n" +
            "      hdh                                         \n" +
            "     hdddhh                                       \n" +
            "    hhdddddhh                                     \n" +
            "    hdddddddh                                     \n" +
            "    hHddHdddhh                                    \n" +
            "                          hhhhh                   \n" +
            "   hHHHHHdddhh                                    \n" +
            "                       hhhhdddh                   \n" +
            "  hHHHHHddHHh                                     \n" +
            "                      hhIIIdddhh                  \n" +
            " hhHHdHddHHdhh                                    \n" +
            "     hhhhh            hIIIIIIIdh                  \n" +
            " hHHHHHHddHddHh                                   \n" +
            "    hhHHHhhhh      hhhIIIIIIIIdhh                 \n" +
            "hhHHHHHHHdHHHHhhhhh        hhh                    \n" +
            "   hhHHHHHHHhh     hIhhIIIIIIIIIh                 \n" +
            "                    hhhhh                        h\n" +
            "hHHHHHHHHHHHHHHHHHh      hhhdhhh                  \n" +
            "  hhHHHHHHHHHhh  hhhIIIIhhhhhhIIhh                \n" +
            "                   hddddhh                      hh\n" +
            "HHHHHHHHHHHHHHHHHHhh     hIIdddh          hhhhhhh \n" +
            " hhHHHHHHHHHHHh  hIIIIIhhHHHHhIIIh                \n" +
            "                  hhIIIIdhh                    hhH\n" +
            "HHHHHHHHHHHHHHHHHHHhhh hhhIIIIIdhhh      hhHHHHHh \n" +
            " hHHHHHHHHHHHHhhhhhhhhhhHHHHHhhhhhh               \n" +
            "    hhhhhh       hIIIIIIIddh hhhhh           hhhHH\n" +
            "HHHHHHHHHHHHHHHHHHHHHhhhIIIIIIIIddIhhh  hhhHHHHHhh\n" +
            "hhHHHHHHHHHHHHHHHHHHHHhHHHHHHHhHHhhh     hhhhh    \n" +
            "   hHHHHHh      hIIIIIIIIIIIhhIIIhh         hhHHHH\n" +
            "HHHHHHHHHHHHHHHHHHHHHHHhhhIIIIIIIIIIIhhhhHHHHHHHHH\n" +
            "HhHHHHHHHHHHHHHHHHHHHhhHHHHHHHHHHHHh    hhHHHh    \n" +
            "  hHHHHHHhh   hhIIIIIIIIIIIIhIIIIIhh       hhHHHHH\n" +
            "HHHHHHHHHHHHHHHHHHHHHHHHHhhhIIIIIIIhhHHHHHHHHHHHHH\n" +
            "HHHHHHHHHHHHHHHHHHHHhhHHHHHHHHHHHHHhhhhhhHHHHHhh  \n" +
            " hHHHHHHHHHhhhIhhhhhhhIIIIIIIIIIIIIhhh    hhHHHHHH\n" +
            "HHHHHHhhHHHHHHHHHHHHHHHHHHHhhhhhhhhhHHHHHHHHHHHHHH\n" +
            "HHHHHHHHHHHHHHHHHHHhhhHHHHHHHHHHHHHHhHHHHHHHHHHhhh\n" +
            "hHHHHHHHHHHHHhhHHHHHHHhhIIIIIIIIIIIIIhh  hhHHHHHHH\n" +
            "HHHhhhhhhhhHHHhhhhhhhhHHHHHHHHHHHHHHHHHHHHhhhHHHHH\n" +
            "HHHHHHhhhhhhhHHhhhhhHhHHHHHHHHHHHHHHHHHHHHHHHHHHHh\n" +
            "hHHHHHHHHHHHHHHHHHHHHHHHhhIIIIIIIIIIhHhhhhHHHHHHHH\n" +
            "HHhhjjjjjjhhHhhjjjjjjhhHHHHHHHHHHHHHHHHHHhhjhhhhhh\n" +
            "hhhhHHhjjjjjhHHhHhHHHHHHHHHHHHHHHhhhhhhhhhHHHHHHHH\n" +
            "HHHHHHHHHHHHHHHHHHHHHHHHHhhhIIIIIIIhHHHhhHHHHHHHHH\n" +
            "HhhjjjjjjjjhhhjjjjjjjjhhhhhHHHHHHHHHHHHHhhjjjjjhjj\n" +
            "jjjhhhhjjjjjhhhhHHHHHHHHHHHHHHHHhhjjjjjjjhhhhHHHHH\n" +
            "HHHHHHHHHHHHHHHHHHHHHHHHHHHHhhhhhhhhHHHhHHHHHhhhhh\n" +
            "hjjjjjjjjjjjjjjjjjjjjjjjjjhhHHHHHHHHHHhhjjjjjjjjjj\n" +
            "jjjjjjjjjjjjjhhHHHHHHHHHHHHHHHHhhjjjjjjjjjjjjhhHHH\n" +
            "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHhhHHHHHHHhhhhjjj\n" +
            "jjjjjjjjjjjjjjjjjjjjjjjjjjjhhhHHHHHhhhjjjjjjjjjjjj\n" +
            "jjjjjjjjjjjjjjhHHHHHHHHHHHHHhhhjjjjjjjjjjjjjjjhhhH";

    private final static String SKYLINE1 ="\n";

    public Skyline(GameView gameView){
        super(gameView);
        super.size = 2;
        super.width = (int) (50*size);
        super.height = (int) (64*size);
        super.rotation = 0;
        super.position = new Position(0, 330);
        gameView.setColorForBlockImage('d', new Color(64, 195, 255));
        gameView.setColorForBlockImage('h', new Color(1, 97, 100));
        gameView.setColorForBlockImage('H', new Color(0, 150, 167));
        gameView.setColorForBlockImage('j', new Color(23, 173, 136));
        gameView.setColorForBlockImage('I', new Color(53, 115, 196));
    }

    @Override
    public void updateStatus(){

    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(SKYLINE, position.x, position.y, size, rotation);
        gameView.addBlockImageToCanvas(SKYLINE, position.x+width, position.y, size, rotation);
        gameView.addBlockImageToCanvas(SKYLINE, position.x+2*width, position.y, size, rotation);
        gameView.addBlockImageToCanvas(SKYLINE, position.x+3*width, position.y, size, rotation);
        gameView.addBlockImageToCanvas(SKYLINE, position.x+4*width, position.y, size, rotation);
        gameView.addBlockImageToCanvas(SKYLINE, position.x+5*width, position.y, size, rotation);
        gameView.addBlockImageToCanvas(SKYLINE, position.x+6*width, position.y, size, rotation);
        gameView.addBlockImageToCanvas(SKYLINE, position.x+7*width, position.y, size, rotation);
        gameView.addBlockImageToCanvas(SKYLINE, position.x+8*width, position.y, size, rotation);
    }
}
