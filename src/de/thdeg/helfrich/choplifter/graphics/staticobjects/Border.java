package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Background;

import java.awt.*;

/**
 * Represents a Border in the game.
 */
public class Border extends Background {

    private final static String BORDER =
            "WZZZZ\n" +
            "WWWW \n" +
            "ZZWW \n" +
            "ZZZW \n" +
            "ZZZZ \n";
    /**
     * Creates new border.
     *
     * @param gameView Window to show Border on.
     */
    public Border(GameView gameView) {
        super(gameView);
        super.size = 2;
        super.width = (int) (5 * size);
        super.height = (int) (5 * size);
        super.position = new Position(450, 435);
        super.rotation = 0;
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('Z', new Color(122, 119, 119));
    }

    @Override
    public void updateStatus(){

    }

    @Override
    public void addToCanvas(){
        gameView.addBlockImageToCanvas(BORDER, position.x, position.y, size, rotation);
        gameView.addBlockImageToCanvas(BORDER, position.x-50, position.y+15, size, rotation);
        gameView.addBlockImageToCanvas(BORDER, position.x-100, position.y+30, size, rotation);
        gameView.addBlockImageToCanvas(BORDER, position.x-150, position.y+45, size, rotation);
    }

}
