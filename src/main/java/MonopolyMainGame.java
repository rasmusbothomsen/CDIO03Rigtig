import Controllers.GameController;
import FieldHandling.Board;
import GUI.ScoreBoard;
import TurnHandling.Player;

public class MonopolyMainGame {
    public static void main(String[] args) {
        Player[] players = GuiStart.startGuiAndPlayerCreator();
        GameController gameController = new GameController(players);
        Board board = new Board();
        GameController.setUpBoard();
        GameController.startOFGame();
        playTurns();

    }

    private static void playTurns() {
        boolean endOfGame = false;
        while (!endOfGame) {
            GameController.playOneTurn();
            GameController.upDatePlayerBalance();
            if (GameController.returnIfPlayerBroke() != null) {
                endOfGame = true;
            }
        }
        printEndOfGame(GameController.comparePlayerMoney());
    }

    private static void printEndOfGame(Player[] players) {
        String[][] result = new String[4][players.length];
        for (int a = 0, i = 0; i < players.length; i++, a = 0) {

            result[a][i] = "#" + i;
            a++;
            result[a][i] = players[i].getName();
            a++;
            result[a][i] = players[i].getMoney() + "$";
            a++;
            result[a][i] = GameController.getPlayerHouses(players[i]);

        }
        new ScoreBoard(result);
    }
}
