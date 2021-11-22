package GUI;

import Controllers.GameController;
import gui_main.GUI;

import java.awt.*;

public class StartTester {
    public static void main(String[] args) {
    GUI_shipping[] ship = new GUI_shipping[1];
           ship[0] = new GUI_shipping("src/main/resourcesPictures/blå.png","r","r","r",",", Color.WHITE,Color.BLACK);
    GUI gui = new GUI(ship);
    ship[0].setHouses(1);
    }
}
