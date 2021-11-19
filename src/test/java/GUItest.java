import Controllers.GUIcreator;
import gui_main.GUI;
import org.junit.jupiter.api.Test;

import java.awt.*;

class GUItest {

    @Test
    void guiTest(){
            GUI gui = new GUI(GUIcreator.guiCreator(), Color.GRAY.brighter());


    }
}
