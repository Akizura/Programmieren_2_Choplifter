package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.game.managers.GameObjectManager;
import de.thdeg.helfrich.choplifter.game.managers.InputManager;
import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.Chopper;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * A shot of the chopper
 */
public class ChopperShot extends Shot implements MovingGameObject {

    private Chopper chopper;
    private InputManager inputManager;
    private String objectID;

    /**
     * Creates a shot of the chopper.
     * @param gameView Window to show the chopperShot on.
     */
    public ChopperShot(GameView gameView, Chopper chopper, GameObjectManager gameObjectManager){
        super(gameView);
        this.chopper = chopper;
        this.gameObjectManager = gameObjectManager;
        this.position = new Position(GameView.WIDTH/2d, GameView.HEIGHT);
        /*this.inputManager = inputManager;*/
        this.speedInPixel = 2.5;
        this.size = 2;
        this.width = (int) (4 * size);
        this.height = (int) (2 * size);
        this.objectID = "ChopperShot" +position.x + position.y;
    }

    @Override
    public void updatePosition() {
        for(ChopperShot chopperShot : gameObjectManager.getChopperShots()){
        if(chopper.getMoveLeft() == true){
            position.left(speedInPixel);}
        else if (chopper.getMoveRight() == true){
            position.right(speedInPixel); }
        else if (chopper.getMoveVertically() == true){
            position.down(speedInPixel); }}

        /*Integer[] pressedKeys = gameView.getKeyCodesOfCurrentlyPressedKeys();
        for (int keyCode : pressedKeys) {
            if (keyCode == KeyEvent.VK_LEFT){
                this.position.left(speedInPixel);
            }
            else if (keyCode == KeyEvent.VK_RIGHT){
                this.position.right(speedInPixel);
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
        else if (position.y > GameView.HEIGHT) {
            gamePlayManager.destroy(this);
        }
        else if (position.x < 0) {
            gamePlayManager.destroy(this);
        }
        else if (position.x > GameView.WIDTH) {
            gamePlayManager.destroy(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.x, position.y + 29/*chopper.getHeight()/2d*/, width, height, 0, true, Color.WHITE);
    }
}
