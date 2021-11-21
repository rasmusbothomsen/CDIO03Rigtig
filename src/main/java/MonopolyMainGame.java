import Controllers.GameController;
import TurnHandling.Player;

public class MonopolyMainGame {
    public static void main(String[] args) {
        Player[] players = GuiStart.startGuiAndPlayerCreator();
        GameController gameController = new GameController(players);

    }
}
