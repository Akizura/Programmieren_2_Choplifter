package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;

import java.awt.*;

/**
 * A shot of a tank.
 */
public class TankShot extends Shot implements MovingGameObject {

    /**
     * Creates a shot of a tank.
     * @param gameView Window to show the tankShot on.
     */
    public TankShot(GameView gameView){
        super(gameView);
        this.speedInPixel = 1;
        this.size = 1;
        this.rotation = 0;
        this.width = (int) (5 * size);
        this.height = (int) (3 * size);
    }

    @Override
    public void updatePosition() {
        position.up(speedInPixel);
    }

    @Override
    public void updateStatus() {
        if (position.y < 0) {
            gamePlayManager.destroy(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.x, position.y, width, height, 0, true, Color.WHITE);

    }

}
