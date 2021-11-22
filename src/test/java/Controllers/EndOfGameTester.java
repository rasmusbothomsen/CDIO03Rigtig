package Controllers;

import GUI.GUIHandler;
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
    players[0].setMoney(0);
    GameController.upDatePlayerBalance();
    assertNull(GameController.returnIfPlayerBroke());
    }
}
