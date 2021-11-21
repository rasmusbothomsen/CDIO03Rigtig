package Controllers;

import FieldHandling.ChanceCard;
import Objects.PlayerCreators;
import TurnHandling.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GUIHandlerTest {

    @Test
     void testAskToRoll(){

        GUIHandler guiHandler = new GUIHandler(PlayerCreators.createPlayers());
        ChanceCard chanceCard = new ChanceCard("abe","monkeyy",2);
        GUIHandler.askToRoll("roll please");

    }

}