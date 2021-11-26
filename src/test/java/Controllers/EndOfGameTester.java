package Controllers;

import controllers.GameController;
import controllers.TextFileReader;
import gUI.ScoreBoard;
import org.junit.jupiter.api.Test;
import turnHandling.Player;


class EndOfGameTester {
    @Test
    void testEndGame(){
    new TextFileReader(".txt");
    Player[] players = {new Player("test",0),new Player("test2",1),new Player("test2",2)};
    new GameController(players);
    GameController.setUpBoard();
    players[0].setMoney(0);
    GameController.upDatePlayerBalance();
    printEndOfGame(players);
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
            result[a][i] = "3";

        }
        new ScoreBoard(result);
    }
}
