package de.thdeg.helfrich.choplifter.graphics.mobileobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.GameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.MovementPatterns;
import de.thdeg.helfrich.choplifter.graphics.basics.MovingGameObject;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Represents a ball with random movements
 */
public class RandomBall extends GameObject implements MovingGameObject {

    private Position targetPosition;
    private Random random;
    private MovementPatterns movementPatterns;
    private ArrayList<Position> movementPattern;
    private int currentPosition;

    /**
     * Creates a RandomBall
     * @param gameView Window to show the gameobject on
     */
    public RandomBall(GameView gameView){
        super(gameView);
        random = new Random();
        super.position = new Position(0, 0);
        super.size = 50;
        super.width = (int) (1 * size);
        super.height = (int) (1 * size);
        super.rotation = 0;
        super.speedInPixel = 4;
        this.movementPatterns = new MovementPatterns();
        this.movementPattern = movementPatterns.getRandomPattern();
        this.targetPosition = movementPattern.get(0);
        this.currentPosition = 0;
    }

    @Override
    protected void updateStatus() {
    }

    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.x, position.y, width, height, 2,true, Color.YELLOW);
        gameView.addOvalToCanvas(targetPosition.x, targetPosition.y, width, height, 2,false, Color.WHITE);
    }

    @Override
    public void updatePosition() {
            /*while(position.y < targetPosition.y) {
                position.down(speedInPixel);
            }
            while(position.x < targetPosition.x) {
                position.right(speedInPixel);
            }*/

        double distance = position.distance(targetPosition);
        if (distance >= speedInPixel) {
            position.right((targetPosition.x - position.x) / distance * speedInPixel);
            position.down((targetPosition.y - position.y) / distance * speedInPixel);
        } else {
            setNewTargetPosition();
            }
  /*
        position.right(speedInPixel);
        position.y = position.y + Math.round(Math.sin(Math.toRadians(position.x * 2)));
        */
        }


    /** Set position to aim at */
    public void setNewTargetPosition() {
        if (currentPosition < movementPattern.size() - 1) {
            currentPosition++;
        } else {
            currentPosition = 0;
            movementPattern = movementPatterns.getRandomPattern();
        }
        targetPosition = movementPattern.get(currentPosition);
        }

    @Override
    public RandomBall clone() {
        return (RandomBall) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RandomBall randomBall = (RandomBall) o;
        return targetPosition == randomBall.targetPosition && random == randomBall.random;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), targetPosition, random);
    }

}
