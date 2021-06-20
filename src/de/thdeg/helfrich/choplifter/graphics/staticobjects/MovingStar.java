package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;
import java.util.Random;

/**
 * Represents blinking Stars in the game.
 */
public class MovingStar extends Background {

    private final static String MOVINGSTAR =
            "              zz                   \n" +
            "              zz                   \n" +
            "              zz                   \n" +
            "              zz                   \n" +
            "             zzzz                  \n" +
            "             zzzz                  \n" +
            "             zzzz                  \n" +
            "             zzzz                  \n" +
            "            zzzzzz                 \n" +
            "            zzzzzz                 \n" +
            "            zzzzzz                 \n" +
            "          zzzzzzzzzz               \n" +
            "      zzzzzzzzzzzzzzzzzz           \n" +
            " zzzzzzzzzzzzzzzzzzzzzzzzzzzz      \n" +
            " zzzzzzzzzzzzzzzzzzzzzzzzzzzz      \n" +
            "      zzzzzzzzzzzzzzzzzz           \n" +
            "          zzzzzzzzzz               \n" +
            "            zzzzzz                 \n" +
            "            zzzzzz                 \n" +
            "            zzzzzz                 \n" +
            "             zzzz                  \n" +
            "             zzzz                  \n" +
            "             zzzz                  \n" +
            "             zzzz                  \n" +
            "              zz                   \n" +
            "              zz                   \n" +
            "              zz                   \n" +
            "              zz                   \n";

    private final static String SPINNER =
                    "              zz                   \n" +
                    "              zz                   \n" +
                    "              zz                   \n" +
                    "              zz                   \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "            zzzzzz                 \n" +
                    "            zzzzzz                 \n" +
                    "            zzzzzz                 \n" +
                    "          zzzzzzzzzz               \n" +
                    "      zzzzzzzzzzzzzzzzzz           \n" +
                    "  zzzzzzzzzzzzzzzzzzzzzzzzzz       \n" +
                    "  zzzzzzzzzzzzzzzzzzzzzzzzzz       \n" +
                    "      zzzzzzzzzzzzzzzzzz           \n" +
                    "          zzzzzzzzzz               \n" +
                    "    zzzzzzzzzzzzzzzzzzzzzz         \n" +
                    "     zzzzzzzzzzzzzzzzzzzz          \n" +
                    "      zzzzzzzzzzzzzzzzzz           \n" +
                    "       zzzzzzzzzzzzzzzz            \n" +
                    "        zzzzzzzzzzzzzz             \n" +
                    "         zzzzzzzzzzzz              \n" +
                    "          zzzzzzzzzz               \n" +
                    "           zzzzzzzz                \n" +
                    "            zzzzzz                 \n" +
                    "             zzzz                  \n" +
                    "              zz                   \n";


    private Random random;
    private String objectID;

    /**
     * Creates a new movingStar.
     *
     * @param gameView Window to show the stars on.
     */
    public MovingStar(GameView gameView) {
        super(gameView);
        this.random = new Random();
        super.position = new Position(random.nextInt(gameView.WIDTH-width), random.nextInt(gameView.HEIGHT-200));
        super.size = 0.45;
        super.width = (int) (35 * size);
        super.height = (int) (28 * size);
        super.rotation = random.nextInt(90);
        this.objectID = "STAR" + position.x + position.y;
        gameView.setColorForBlockImage('z', new Color(104, 0, 102));
    }



    @Override
    public void updateStatus(){

    }

    @Override
    public void addToCanvas(){
        gameView.addBlockImageToCanvas(MOVINGSTAR, position.x, position.y, size, 0);
    }

}
