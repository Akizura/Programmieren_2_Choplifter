package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.basics.Position;

import java.awt.*;
import java.util.Random;

/**
 * Represents the fixed stars in the game
 */
public class FixedStar extends Background {

    private final static String FIXSTAR =
                    "              zz                   \n" +
                    "              zz                   \n" +
                    "              zz                   \n" +
                    "              zz                   \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "            zzzzzz                 \n" +
                    "            zzzzzz                 \n" +
                    "            zzzzzz                 \n" +
                    "          zzzzzzzzzz               \n" +
                    "      zzzzzzzzzzzzzzzzzz           \n" +
                    " zzzzzzzzzzzzzzzzzzzzzzzzzzzz      \n" +
                    " zzzzzzzzzzzzzzzzzzzzzzzzzzzz      \n" +
                    "      zzzzzzzzzzzzzzzzzz           \n" +
                    "          zzzzzzzzzz               \n" +
                    "            zzzzzz                 \n" +
                    "            zzzzzz                 \n" +
                    "            zzzzzz                 \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "             zzzz                  \n" +
                    "              zz                   \n" +
                    "              zz                   \n" +
                    "              zz                   \n" +
                    "              zz                   \n";


    private String objectID;
    private Random random;

    /**
     * Creats a FixedStar
     * @param gameView Window to show the gameobject on
     */
    public FixedStar(GameView gameView){
        super(gameView);
        this.random = new Random();
        super.size = 1;
        super.width = (int) (35 * size);
        super.height = (int) (28 * size);
        super.rotation = 0;
        /*super.position = new Position(position.x, position.y);*/
        super.position = new Position(random.nextInt(gameView.WIDTH-width), random.nextInt(gameView.HEIGHT-200));
        this.objectID = "FixedStar" + position.x + position.y;
        gameView.setColorForBlockImage('z', new Color(104, 0, 102));
    }

    private void blinking() {
        boolean showBlock1 = true;
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", objectID, 1000);
            showBlock1 = !showBlock1;
            System.out.println("fixedStar1 disappeared");
        }
        if (showBlock1) {
            gameView.addBlockImageToCanvas(FIXSTAR, 300, 300, size, rotation);
            System.out.println("fixedStar1 is showing");
        }

        /*boolean showBlock2 = false;
        this.position = new Position(600, 200);
        getObjectID();
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", objectID, 800);
            showBlock2 = !showBlock2;
            System.out.println("fixedStar2 disappeared");
        }
        if (showBlock2) {
            gameView.addBlockImageToCanvas(FIXSTAR, 600, 200, size, rotation);}
        System.out.println("fixedStar2 is showing");


        boolean showBlock3 = false;
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", objectID, 1000);
            showBlock3 = !showBlock3;
        }
        if (showBlock3) {
            gameView.addBlockImageToCanvas(FIXSTAR, 400, 150, size, rotation);}


        boolean showBlock4 = false;
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", objectID, 700);
            showBlock4 = !showBlock4;
        }
        if (showBlock4) {
            gameView.addBlockImageToCanvas(FIXSTAR, 800, 250, size, rotation);}


        boolean showBlock5= false;
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", objectID, 450);
            showBlock5 = !showBlock5;
        }
        if (showBlock5) {
            gameView.addBlockImageToCanvas(FIXSTAR, 500, 350, size, rotation);}


        boolean showBlock6 = false;
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", objectID, 200);
            showBlock6 = !showBlock6;
        }
        if (showBlock6) {
            gameView.addBlockImageToCanvas(FIXSTAR, 50, 100, size, rotation); }

        boolean showBlock7 = false;
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", objectID, 500);
            showBlock7 = !showBlock7;
        }
        if (showBlock7) {
            gameView.addBlockImageToCanvas(FIXSTAR, 150, 180, size, rotation);}


        boolean showBlock8 = false;
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", objectID, 900);
            showBlock8 = !showBlock8;
        }
        if (showBlock8) {
            gameView.addBlockImageToCanvas(FIXSTAR, 100, 380, size, rotation);
        }*/
    }

    /**
     * Gettermethod fpr the ObjectID
     * @return objectID
     */
    public String getObjectID() {
        return objectID;
    }

    @Override
    public void updateStatus(){
    }

    @Override
    public void addToCanvas() {
            blinking();
    }
}
