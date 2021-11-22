package GUI;

import Controllers.GameController;
import Controllers.TextFileReader;
import gui_main.GUI;

import java.awt.*;
import java.net.URL;

public class StartTester {
    public static void main(String[] args) {
        new TextFileReader(".txt");
        IntroGui introGui = new IntroGui();
    }
}
