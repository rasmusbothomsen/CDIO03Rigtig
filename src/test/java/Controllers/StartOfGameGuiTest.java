package Controllers;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.*;

class StartOfGameGuiTest {
    public static void main(String[] args) {
        guiTester();
    }
    public static void guiTester(){
        StartOfGameGui startOfGameGui = new StartOfGameGui();
        JFrame frame = startOfGameGui.whatLanguage();
    }

}