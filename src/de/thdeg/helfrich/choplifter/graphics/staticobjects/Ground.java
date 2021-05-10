package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;

import java.awt.*;

/**
 * Represents the ground for some of the gameObjects in the game.
 */
public class Ground extends Background{

    /**
     * Creates a ground on which the tank, the hostages and the buildings can stand on.
     * @param gameView Window to show the ground on.
     */
    public Ground (GameView gameView){
        super(gameView);
        this.width = GameView.WIDTH;
        this.height = 100;
        this.position = new Position(0, GameView.HEIGHT - height);
    }

    @Override
    public void updateStatus() {

    }

    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(position.x, position.y, width, height, 0, true, Color.pink);
    }
}
