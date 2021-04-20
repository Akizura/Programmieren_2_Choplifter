package de.thdeg.helfrich.choplifter.gameobjects;

import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;

/**
 * Represents a Base in the game.
 */
abstract class Base extends GameObject {

    private int hostagesInside;

    /**
     * Creates a new base.
     * @param gameView Window to show the base on.
     */
    public Base(GameView gameView){
        super(gameView);
        super.position = new Position(300, 400);
        super.size=1.85;
        super.width = (int) (40 * size);
        super.height = (int) (25 * size);
        super.rotation = 0;
        this.hostagesInside = 0;
    }
}
