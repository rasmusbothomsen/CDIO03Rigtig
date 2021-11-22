import Controllers.GameController;
import GUI.ScoreBoard;
import TurnHandling.Player;

public class MonopolyMainGame {
    public static void main(String[] args) {
        Player[] players = GuiStart.startGuiAndPlayerCreator();
        GameController gameController = new GameController(players);
        GameController.startOFGame();
        GameController.setUpBoard();
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
        for (int a = 0, i = 0; a < players.length; a++, i = 0) {

            result[i][a] = "#" + i;
            i++;
            result[i][a] = players[a].getName();
            i++;
            result[i][a] = players[a].getMoney() + "$";
            result[i][a] = GameController.getPlayerHouses(players[a]);

        }
        new ScoreBoard(result);
    }
}
