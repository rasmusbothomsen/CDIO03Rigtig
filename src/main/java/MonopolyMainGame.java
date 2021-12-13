import controllers.GameController;
import fieldHandling.Board;
import gUI.ScoreBoard;
import turnHandling.Player;

public class MonopolyMainGame {
    public static void main(String[] args) {
        Player[] players = GuiStart.startGuiAndPlayerCreator();
         new GameController(players);
         new Board();
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
        String[][] result = new String[players.length][4];
        for (int a = 0, i = 0,b = players.length-1; a < players.length; a++, i = 0,b--) {

            result[a][i] = "#" + (a+1);
            i++;
            result[a][i] = players[b].getName();
            i++;
            result[a][i] = players[b].getMoney() + "$";
            i++;
            result[a][i] = GameController.getPlayerHouses(players[b]);

        }
        new ScoreBoard(result);
    }
}
