package Controllers;

import FieldHandling.ChanceCard;
import GUI.GUIHandler;
import Objects.PlayerCreators;
import org.junit.jupiter.api.Test;

class GUIHandlerTest {

    @Test
     void testAskToRoll(){
        new TextFileReader(".txt");
        GUIHandler guiHandler = new GUIHandler(PlayerCreators.createPlayers());

    }

}