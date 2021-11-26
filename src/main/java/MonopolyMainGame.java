import controllers.GameController;
import fieldHandling.Board;
import gUI.ScoreBoard;
import turnHandling.Player;

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
        String[][] result = new String[players.length][4];
        for (int a = 1, i = 0; a < players.length; a++, i = 0) {

            result[a][i] = "#" + (a+1);
            i++;
            result[a][i] = players[players.length-a-1].getName();
            i++;
            result[a][i] = players[players.length-a-1].getMoney() + "$";
            i++;
            result[a][i] = GameController.getPlayerHouses(players[players.length-a-1]);

        }
        new ScoreBoard(result);
    }
}
