package de.thdeg.helfrich.choplifter.game.managers;

import de.thdeg.helfrich.choplifter.gameview.GameView;
import de.thdeg.helfrich.choplifter.graphics.mobileobjects.Chopper;

import java.awt.event.KeyEvent;

/**
 * This class manages the user inputs.
 */
public class InputManager {

    private GameView gameView;
    private Chopper chopper;
    private static final boolean DIAGONALMOVEMENT = false;

    /**
     * Creates a new InputManager.
     *
     * @param gameView Window to show game objects on.
     * @param chopper  GameObject that is in the control of the player.
     */
    public InputManager(GameView gameView, Chopper chopper) {
        this.gameView = gameView;
        this.chopper = chopper;
    }


    /*void updateUserInputs() {
        Integer[] keyCodesOfCurrentlyPressedKeys = gameView.getKeyCodesOfCurrentlyPressedKeys();
        if (DIAGONALMOVEMENT == true) {
            for (int keyCode : keyCodesOfCurrentlyPressedKeys) {
                processKeyCode(keyCode);
            }
        } else {
            if (keyCodesOfCurrentlyPressedKeys.length > 0) {
                processKeyCode(keyCodesOfCurrentlyPressedKeys[0]);
            }
        }
    }

    private void processKeyCode(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT) {
            chopper.left();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            chopper.right();
        } else if (keyCode == KeyEvent.VK_UP) {
            chopper.up();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            chopper.down();
        } else if (keyCode == KeyEvent.VK_SPACE) {
            chopper.shoot();
        }
    }*/

    /**
     * This enables the user to take action.
     */
    public void updateUserInputs() {
        Integer[] pressedKeys = gameView.getKeyCodesOfCurrentlyPressedKeys();
        if (DIAGONALMOVEMENT == true) {
            directions();
        } else {
            if (DIAGONALMOVEMENT == false) {
                for (int keyCode : pressedKeys) {
                    if (keyCode == KeyEvent.VK_UP) {
                        chopper.up();
                        break;
                    }
                    if (keyCode == KeyEvent.VK_DOWN) {
                        chopper.down();
                        break;
                    }
                    if (keyCode == KeyEvent.VK_RIGHT) {
                        chopper.right();
                        break;
                    }
                    if (keyCode == KeyEvent.VK_LEFT) {
                        chopper.left();
                        break;
                    }
                    if (keyCode == KeyEvent.VK_SPACE) {
                        chopper.shoot();
                        break;
                    }
                }
            }
        }
    }

    /**
     * This manages the directions the user can move to.
     */
    public void directions() {
        Integer[] pressedKeys = gameView.getKeyCodesOfCurrentlyPressedKeys();
        for (int keyCode : pressedKeys) {
            if (keyCode == KeyEvent.VK_UP) {
                chopper.up();
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                chopper.down();
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                chopper.right();
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                chopper.left();
            }
            if (keyCode == KeyEvent.VK_SPACE) {
                chopper.shoot();
            }
        }
    }

}
