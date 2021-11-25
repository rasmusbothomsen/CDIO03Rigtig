package Controllers;

import GUI.GUIHandler;
import GUI.ScoreBoard;
import Objects.PlayerCreators;
import TurnHandling.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class EndOfGameTester {
    @Test
    void testEndGame(){
    new TextFileReader(".txt");
    Player[] players = {new Player("test",0),new Player("test2",1)};
    new GameController(players);
    GameController.setUpBoard();
    players[0].setMoney(0);
    GameController.upDatePlayerBalance();
    printEndOfGame(players);
    }
    private static void printEndOfGame(Player[] players) {
        String[][] result = new String[players.length][4];
        for (int a = 0, i = 0; a < players.length; a++, i = 0) {

            result[a][i] = "#" + (a+1);
            i++;
            result[a][i] = players[a].getName();
            i++;
            result[a][i] = players[a].getMoney() + "$";
            i++;
            result[a][i] = "3";

        }
        new ScoreBoard(result);
    }
}
