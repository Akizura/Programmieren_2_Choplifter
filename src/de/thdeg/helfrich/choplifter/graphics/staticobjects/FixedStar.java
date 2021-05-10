package de.thdeg.helfrich.choplifter.graphics.staticobjects;

import de.thdeg.helfrich.choplifter.gameview.GameView;

import java.awt.*;

public class FixedStar extends Background {

    private final static String FIXSTAR = "m";

    public FixedStar(GameView gameView){
        super(gameView);
        gameView.setColorForBlockImage('M', Color.MAGENTA);
    }

    private void blinking() {
        /*boolean showBlock = false;
        if (gameView.timerExpired("StarBlink", objectID)) {
            gameView.setTimer("StarBlink", , 1000);
            showBlock = !showBlock;
        }
        if (showBlock) {
            gameView.addBlockImageToCanvas(FIXSTAR, position.x, position.y, 5, 0);
            /*gameView.setColorForBlockImage('z', new Color(104, 0, 102));
        }*/
            /*else {
                gameView.addBlockImageToCanvas(STAR2, position.x, position.y, 5, 0);*/
        /*gameView.setColorForBlockImage('z', Color.MAGENTA);
            }*/
    }

    @Override
    public void updateStatus(){}

    @Override
    public void addToCanvas(){
        blinking();
    }
}
