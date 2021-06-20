package de.thdeg.helfrich.choplifter.game.utilities;

/**
 * Represents the Player in the game
 */
public class Player {

    public static final int MAXIMUM_NUMBER_OF_LIVES = 3;
    /**
     * The name of the Player
     */
    public String name;
    /**
     * The current level in the game
     */
    public Level level;
    /**
     * The current difficulty of the game
     */
    public boolean difficultyIsSetToEasy;
    /**
     * The current number of lives
     */
    public int lives;
    /**
     * The number of dead hostages
     */
    public int deadHostages;
    /**
     * The number of passengers in the helicopter
     */
    public int passengersInHelicopter;
    /**
     * The number of hostages rescued
     */
    public int hostagesRescued;

    /**
     * Creates a player
     */
    public Player(){
        this.lives = MAXIMUM_NUMBER_OF_LIVES;
    }

}
