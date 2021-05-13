package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.game.managers.GameObjectManager;
import de.thdeg.helfrich.choplifter.game.managers.InputManager;
import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
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
        this.speedInPixel = 1;
        this.size = 2;
        this.width = (int) (4 * size);
        this.height = (int) (2 * size);
        this.objectID = "ChopperShot" +position.x + position.y;
        super.hitBox = new Rectangle((int) position.x, (int) position.y,width-1, height-1);
    }

    @Override
    public void updatePosition() {
        for(ChopperShot chopperShot : gameObjectManager.getChopperShots()){
        if(chopper.getMoveLeft() == true){
            position.left(speedInPixel);
            break;}

        if (chopper.getMoveRight() == true){
            position.right(speedInPixel);
            break; }

        if (chopper.getMoveVertically() == true){
            position.down(speedInPixel);
            break;}
        }

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
        if (chopper.getMoveVertically()==true){
        gameView.addOvalToCanvas(position.x+25, position.y + 29/*chopper.getHeight()/2d*/, width, height, 0, true, Color.WHITE);}
        else{
            gameView.addOvalToCanvas(position.x, position.y + 29/*chopper.getHeight()/2d*/, width, height, 0, true, Color.WHITE);}
        gameView.addRectangleToCanvas(hitBox.x, hitBox.y, hitBox.width, hitBox.height, 1, false, Color.RED);
    }

    @Override
    protected void updateHitBoxPosition() {
        if(chopper.getMoveLeft() == true){
        hitBox = new Rectangle((int) position.x-4, (int) position.y+27,hitBox.width, hitBox.height);}
        if(chopper.getMoveRight() == true){
            hitBox = new Rectangle((int) position.x-4, (int) position.y+27,hitBox.width, hitBox.height);}
        if(chopper.getMoveVertically() == true){
            hitBox = new Rectangle((int) position.x+21, (int) position.y+27,hitBox.width, hitBox.height);}
    }

    @Override
    protected void reactToCollision(CollidableGameObject otherObject) {

    }
}
