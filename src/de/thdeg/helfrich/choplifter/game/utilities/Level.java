package de.thdeg.helfrich.choplifter.game.utilities;

/**
 *Represents a level of the game
 */
public class Level {

    /**
     * The name of the level
     */
    public String name;

    /**
     * The number of enemies in a level
     */
    public int numberOfEnemies;

    /**
     * Creates a level
     * @param name The name of the level
     * @param numberOfEnemies The number of enemies in a level
     */
    public Level(String name, int numberOfEnemies){
        this.name = name;
        this.numberOfEnemies = numberOfEnemies;
    }
}
