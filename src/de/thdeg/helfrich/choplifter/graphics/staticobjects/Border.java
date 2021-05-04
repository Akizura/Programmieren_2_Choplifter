package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Background;

import java.awt.*;

/**
 * Represents a Border in the game.
 */
public class Border extends Background {

    private final static String BORDER =
            "Wggg\n" +
            "WWW \n" +
            "gWW \n" +
            "ggW \n" +
            "ggg \n";
    /**
     * Creates new border.
     *
     * @param gameView Window to show Border on.
     */
    public Border(GameView gameView) {
        super(gameView);
        gameView.setColorForBlockImage('W', Color.WHITE);
        gameView.setColorForBlockImage('g', new Color(122, 119, 119));
    }

    @Override
    public void updateStatus(){

    }

    @Override
    public void addToCanvas(){
        gameView.addBlockImageToCanvas(BORDER, 550, 450, 3, 0);
    }

}
