package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;

import java.awt.*;
import java.util.Random;

/**
 * Represents a ball which follows the random ball
 */
public class FollowerBall extends GameObject implements MovingGameObject {

    private enum Status {CENTER, FOLLOW, HIDE}

    private final RandomBall followMe;
    Position targetPosition;
    Random random;
    private  Status status;

    /**
     * Creates a FollowerBall
     * @param gameView Window to show the gameobject on
     * @param followMe The RandomBall to follow.
     */
    public FollowerBall(GameView gameView, RandomBall followMe){
        super(gameView);
        random = new Random();
        super.position = new Position(GameView.WIDTH, GameView.HEIGHT);
        super.size = 50;
        super.width = (int) (1 * size);
        super.height = (int) (1 * size);
        super.rotation = 0;
        super.speedInPixel = 3;
        this.followMe = followMe;
        this.status = Status.FOLLOW;
    }

    @Override
    protected void updateStatus() {
    }

    @Override
    public void addToCanvas() {
        if (status == Status.HIDE) {
            gameView.addOvalToCanvas(position.x, position.y, width, height, 2,true, Color.WHITE);
        } else {
            gameView.addOvalToCanvas(position.x, position.y, width, height, 2,true, Color.GREEN);
        }
    }

    @Override
    public void updatePosition() {
        if (gameView.timerExpired("Status", "FollowerBall")) {
            gameView.setTimer("Status", "FollowerBall", 3000);
            switch (status) {
                case HIDE:
                    status = Status.CENTER;
                    break;
                case CENTER:
                    status = Status.FOLLOW;
                    break;
                case FOLLOW:
                    status = Status.HIDE;
                    break;
            }
        }
        if (status == Status.FOLLOW) {
            targetPosition = followMe.getPosition().clone();
            targetPosition.y += 25;
        } else if (status == Status.CENTER) {
            targetPosition = new Position(GameView.WIDTH / 2d, GameView.HEIGHT / 2d);
        }
        if (status != Status.HIDE) {
            double distance = position.distance(targetPosition);
            if (distance >= speedInPixel) {
                position.right((targetPosition.x - position.x) / distance * speedInPixel);
                position.down((targetPosition.y - position.y) / distance * speedInPixel);
            }
        }
    }
    }
