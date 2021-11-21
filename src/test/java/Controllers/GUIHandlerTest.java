package Controllers;

import FieldHandling.ChanceCard;
import GUI.GUIHandler;
import Objects.PlayerCreators;
import org.junit.jupiter.api.Test;

class GUIHandlerTest {

    @Test
     void testAskToRoll(){

        GUIHandler guiHandler = new GUIHandler(PlayerCreators.createPlayers());
        ChanceCard chanceCard = new ChanceCard("abe","monkeyy",2);
        GUIHandler.askToRoll("roll please");

    }

}