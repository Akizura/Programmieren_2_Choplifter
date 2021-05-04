package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;

import java.awt.*;

/**
 * A shot of the jet.
 */
public class JetShot extends Shot implements MovingGameObject {

    /**
     * Creates the shots of the jets.
     * @param gameView Window to show the jetShots on.
     */
    public JetShot(GameView gameView){
        super(gameView);
        this.speedInPixel = 1;
        this.size = 1;
        this.rotation = 0;
        this.width = (int) (5 * size);
        this.height = (int) (3 * size);
    }

    @Override
    public void updatePosition() {
        position.down(speedInPixel);
    }

    @Override
    public void updateStatus() {
        if (position.y > GameView.HEIGHT - 30) {
            gamePlayManager.destroy(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.x, position.y, width, height, 0, true, Color.WHITE);
    }

}
