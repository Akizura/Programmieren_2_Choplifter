package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.CollidableGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;

import java.awt.*;

/**
 * A shot of the jet.
 */
public class JetShot extends Shot implements MovingGameObject {

    Jet jet;

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
        super.hitBox = new Rectangle((int) position.x, (int) position.y,width-2, height);
    }

    @Override
    protected void updateHitBoxPosition() {
        hitBox = new Rectangle((int) position.x-1, (int) position.y-1,hitBox.width, hitBox.height);
    }

    @Override
    protected void reactToCollision(CollidableGameObject otherObject) {

    }

    @Override
    public void updatePosition() {
        position.right(speedInPixel);
        /*if(jet.getMoveFromLeftToRight() == true){
            position.right(speedInPixel);
        }
        else{position.left(speedInPixel);}*/
    }

    @Override
    public void updateStatus() {
        if (position.y > GameView.HEIGHT) {
            gamePlayManager.destroy(this);
        }
    }

    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.x, position.y, width, height, 0, true, Color.WHITE);
        gameView.addRectangleToCanvas(hitBox.x, hitBox.y, hitBox.width, hitBox.height, 1, false, Color.RED);
    }
}
