package Controllers;
import gui_codebehind.GUI_BoardController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class StartOfGameGui {
    public static void main(String[] args) {
        JButton button = new JButton("Heoo");
        JButton button1 = new JButton("YEYEYE");
        JFrame frame = new JFrame("Games");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(button1);
        frame.add(panel);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("hey");
                panel.remove(button);
                panel.validate();
                panel.repaint();
            }
        });
        String input = JOptionPane.showInputDialog(frame,"Plese","Name",JOptionPane.PLAIN_MESSAGE);

    }

}
