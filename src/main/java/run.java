import Controllers.GUIHandler;
import Controllers.GameController;
import Controllers.StartOfGameGui;
import TurnHandling.Player;
import gui_main.GUI;

import java.util.concurrent.TimeUnit;

public class run {
    public static void main(String[] args) throws InterruptedException {
        StartOfGameGui startOfGameGui = new StartOfGameGui();
        startOfGameGui.whatLanguage();
        System.out.println(startOfGameGui.getLanguage());
    }
}
