package choplifter;
import choplifter.GameView;

public class Start {
    public static void main(String[] args) {
        GameLoopManager gameLoopManager= new GameLoopManager();
        gameLoopManager.startGame();

System.out.println("Spiel");

        //Instantiation of the class Position
        Position positionNormal = new Position(100, 110);
        var positionOther = new Position(200, 300);

        //Move position2 down and right
        positionOther.down();
        positionOther.right();

        //Show new positions of position1 an position2
        System.out.println("The position of positionNormal is " + positionNormal + "and the position of positionOther is " + positionOther + ".");

        //Instantiation of Game Objects
        Tank tank1 = new Tank();
        Hostage hostage1 = new Hostage();

        System.out.println("Info about tank1: " + tank1);
        System.out.println("Info about hostage1: " + hostage1);

        tank1.updatePosition();
        hostage1.updatePosition();

        System.out.println("Info about tank1 after moving: " + tank1);
        System.out.println("Info about hostage1 after moving: " + hostage1);

    }
}
