package GUI;

import Controllers.GameController;
import Controllers.TextFileReader;
import gui_main.GUI;

import java.awt.*;
import java.net.URL;
import java.util.Scanner;

public class StartTester {
    public static void main(String[] args) {
        String[][] test = {{"hey", "heyoo", "hyeoo", "heyy"}, {"yo", "yo", "yo", "yo"}, {"yo", "yo", "yo", "yo"}};
        String[][] result = new String[4][4];
        for (int a = 0, i = 0; a < 4; a++, i = 0) {

            result[i][a] = "#" + i;
            i++;
            result[i][a] = "hey";
            i++;
            result[i][a] = "heyo" + "$";
            result[i][a] = "heyeyeyey";
        }
        new ScoreBoard(test);
    }
}
