package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.actions.Position;
import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.staticobjects.Background;

/**
 * Represents blinking Stars in the game.
 */
public class Star extends Background {

    /**
     * Creates a new star.
     * @param gameView Window to show the stars on.
     */
    public Star(GameView gameView){
        super(gameView);
        super.position = new Position(250, 150);
        super.size=1.85;
        super.width = (int) (5 * size);
        super.height = (int) (5 * size);
        super.rotation = 0;
    }

    private void blinking(){

    }
}
