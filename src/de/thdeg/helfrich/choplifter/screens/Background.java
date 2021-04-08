package de.thdeg.helfrich.choplifter.screens;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.GameObject;

/**
 * Represents the Background in the game.
 */
public class Background extends GameObject {

    /**
     * Creates a background.
     * @param gameView
     */
    Background(GameView gameView){
        super(gameView);
    }

    /**
     * Moves the background.
     */
    @Override
    public void updatePosition(){

    }

    /**
     * Draws the background to the canvas.
     */
    @Override
    public void addToCanvas(){

    }

    private void blinkManager(){

    }

    @Override
    public String toString() {return "Background: (" + "position= " + position + ")";}

}
