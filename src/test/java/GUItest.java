import Controllers.GUIHandler;
import Controllers.GUIcreator;
import gui_main.GUI;
import org.junit.jupiter.api.Test;

class GUItest {

    @Test
    void guiTest(){
        GUI gui = new GUI();
        gui.showMessage("hey");


    }
}
