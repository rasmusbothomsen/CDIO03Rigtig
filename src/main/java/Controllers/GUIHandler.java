package Controllers;

import gui_fields.GUI_Field;
import gui_main.GUI;

public class GUIHandler {
    private static GUI_Field[] fields;
    private static GUI gui;


    public GUIHandler() {
    }

    public static void SetGui(GUI referenceGUI){
        gui=referenceGUI;
    }
    public static void SetGuiField(GUI_Field[] guiFields){
     fields = guiFields;
    }
}
