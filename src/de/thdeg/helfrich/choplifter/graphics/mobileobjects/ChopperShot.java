package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.game.managers.InputManager;
import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * A shot of the chopper
 */
public class ChopperShot extends Shot implements MovingGameObject {

    private Chopper chopper;
    private InputManager inputManager;

    /**
     * Creates a shot of the chopper.
     * @param gameView Window to show the chopperShot on.
     */
    public ChopperShot(GameView gameView){
        super(gameView);
        this.position = new Position(GameView.WIDTH/2d, GameView.HEIGHT);
        this.inputManager = inputManager;
        this.speedInPixel = 2.5;
        this.size = 2;
        this.width = (int) (4 * size);
        this.height = (int) (2 * size);
    }

    @Override
    public void updatePosition() {
        position.left(speedInPixel);
        /*Integer[] pressedKeys = gameView.getKeyCodesOfCurrentlyPressedKeys();
        for (int keyCode : pressedKeys) {
            if (keyCode == KeyEvent.VK_LEFT){
                this.position.left(speedInPixel);
                break;
            }
            else if (keyCode == KeyEvent.VK_RIGHT){
                this.position.right(speedInPixel);
                break;
            }
        }*/
    }

    @Override
    public void updateStatus() {
        destroyShotIfItHasLeftTheScreen();
    }

    private void destroyShotIfItHasLeftTheScreen() {
        if (position.y < 0) {
            gamePlayManager.destroy(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.x, position.y+30, width, height, 0, true, Color.WHITE);
    }
}
