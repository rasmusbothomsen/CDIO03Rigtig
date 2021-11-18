package Controllers;

import FieldHandling.ChanceCard;
import TurnHandling.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GUIHandlerTest {

    @Test
     void testAskToRoll(){
        Player[] players = new Player[4];
        for(int i =0; i<4;i++){
            players[i] = new Player("test"+i,i);
        }
        GUIHandler guiHandler = new GUIHandler(players);
        ChanceCard chanceCard = new ChanceCard("abe","monkeyy",2);
        guiHandler.askToRoll("roll please");

    }

}