import Controllers.GameController;
import Controllers.TextFileReader;
import FieldHandling.Board;
import FieldHandling.FieldHandler;
import TurnHandling.Player;
import gui_main.GUI;
import org.junit.jupiter.api.Test;
import GUI.GUIcreator;
import GUI.GUIHandler;

import java.awt.*;
import java.util.concurrent.CountDownLatch;

class GUItest {

    @Test
    void guiTest() {
        GUI gui = new GUI();


    }

    @Test
    void guiBoardTest() {
        CountDownLatch latch = new CountDownLatch(1);
        new TextFileReader(".txt");
        Player[] players = PlayerTestCreator.testPlayers();
        new GameController(players);
        players[1].setCanSkipJail(true);
        players[1].setPlacementONBoard(18);
        GameController.movePlayer(players[1]);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
