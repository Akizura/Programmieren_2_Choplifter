package choplifter;
import choplifter.GameView;
/**
 * Manages the whole game.
 */
public class Start {
    public static void main(String[] args) {
        GameLoopManager gameLoopManager= new GameLoopManager();
        gameLoopManager.startGame();

        System.out.println("Spiel");

        Position position1 = new Position();
        var position2 = new Position();

        Jet jet1 = new Jet();
        Tank tank1 = new Tank();

        System.out.println(jet1);
        System.out.println(tank1);

        jet1.updatePosition();
        tank1.updatePosition();

        System.out.println(jet1);
        System.out.println(tank1);
    }
}
