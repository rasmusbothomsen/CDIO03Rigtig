package Controllers;

import GUI.GUIHandler;
import Objects.PlayerCreators;
import TurnHandling.Player;
import org.junit.jupiter.api.Test;

class GameControllerTest {
    @Test
    void testSorter(){
        int[] rolls = {2,1,3,6};
        int [][] comparedThrows = GameController.compareThrows(rolls);
    }

    @Test
    void gameTester(){
        Player[] players = new Player[4];
        for(int i =0; i<4;i++){
            players[i] = new Player("test"+i,i);
        }
        GameController gameController = new GameController(players);
        GameController.startOFGame();
    }


    @Test
    void playerOver25Test(){
        Player player = new Player("Test",2);
        player.movePlacementOnBoard(25);
    }

    @Test
    void turnTester(){
        GameController gameController= new GameController(PlayerCreators.createPlayers());
        GUIHandler.addChoice("ABe","Monkey","Vælg sprog");
        GameController.startOFGame();
        GameController.playOneTurn();
    }


    @Test
    void chanceCardTest() throws InterruptedException {

    }

}