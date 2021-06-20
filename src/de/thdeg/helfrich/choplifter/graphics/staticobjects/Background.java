package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;


import java.awt.*;


/**
 * Represents the Background in the game.
 */
public class Background extends GameObject {


    /**
     * Creates a background.
     *
     * @param gameView
     */
    public Background(GameView gameView) {
        super(gameView);
    }

    @Override
    public void updateStatus(){

    }

    /**
     * Draws the background to the canvas.
     */
    @Override
    public void addToCanvas() {
        addColorFadeToCanvas(Color.BLACK, new Color(26, 134, 116));
        /*gameView.addRectangleToCanvas(0, 440, 960, 100, 5, true, Color.DARK_GRAY);*/
    }

    private void addColorFadeToCanvas(Color top, Color bottom) {
        float numberOfcoloredRectangles = 120;
        int heigtOfSingleColorRectangle = Math.round((GameView.HEIGHT - 50) / numberOfcoloredRectangles);
        int redDiff = bottom.getRed() - top.getRed();
        int greenDiff = bottom.getGreen() - top.getGreen();
        int blueDiff = bottom.getBlue() - top.getBlue();
        int redValue;
        int greenValue;
        int blueValue;
        for (int i = 0; i < numberOfcoloredRectangles; i++) {
            redValue = (int) Math.round(top.getRed() + i * (redDiff / numberOfcoloredRectangles));
            greenValue = (int) Math.round(top.getGreen() + i * (greenDiff / numberOfcoloredRectangles));
            blueValue = (int) Math.round(top.getBlue() + i * (blueDiff / numberOfcoloredRectangles));
            gameView.addRectangleToCanvas(position.x, i * heigtOfSingleColorRectangle,
                    GameView.WIDTH - position.x,
                    heigtOfSingleColorRectangle, 0, true,
                    new Color(redValue, greenValue, blueValue));
        }
    }

}
