package GUI;

import Controllers.TextFileReader;
import TurnHandling.Player;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import javax.swing.JOptionPane;


public class PlayerCreation {
    protected JPanel title;
    protected JTextField name;
    protected JComboBox carColor;
    protected JPanel carColorBox;
    protected JButton ok;
    protected JButton cancel;
    protected JFrame frame;
    private CountDownLatch latch;
    private String playerName;
    private String playerColor;
    private int lastIndex;


    public PlayerCreation(String[] colors) {
        frame = new JFrame("PlayerCreation");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1280, 720));
        frame.setResizable(false);

        for (int i = 0; i < colors.length; i++) {
            carColor.addItem(colors[i]);

        }
        name.setText(TextFileReader.getGameText()[63]);// "Indtast dit navn her!"
        frame.add(title);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public String getPlayerName() {
        if (playerName.isEmpty()) {
            return null;
        }
        return playerName;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public void setPlayerInfo() {
        playerName = null;
        playerColor = null;

        name.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int max = 25;
                if (name.getText().length() > max + 1) {
                    e.consume();
                    String shortened = name.getText().substring(0, max);
                    name.setText(shortened);
                } else if (name.getText().length() > max) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        latch = new CountDownLatch(1);
        name.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PlayerCreation.this.name.setText(null);
                name.removeMouseListener(this);
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerCreation.this.playerName = name.getText();
                PlayerCreation.this.playerColor = carColor.getSelectedItem().toString();
                PlayerCreation.this.lastIndex = carColor.getSelectedIndex();
                latch.countDown();
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void playerInfoAccepted() {

        infoBox(TextFileReader.getGameText()[64], "Succses"); // "Spiller oprettet" og "Succes"

        carColor.removeItemAt(carColor.getSelectedIndex());
        name.setText(null);

    }

    public void playerInfoDenied() {
        infoBox(TextFileReader.getGameText()[65], TextFileReader.getGameText()[66]); // Printer "Indtast venligst et gyldigt navn" og "Fejl"
    }

    public void playerInfoDenied(boolean isnotUniqe) {
        infoBox(TextFileReader.getGameText()[67], TextFileReader.getGameText()[66]);
    } // Printer "Navnet er allerede taget, prøv venligst et andet" og "Fejl"

    private static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public int enoughPlayers() {
        int jOptionPane = JOptionPane.showConfirmDialog(null, TextFileReader.getGameText()[68] + TextFileReader.getGameText()[69], "Infobox", JOptionPane.YES_NO_OPTION);
        return jOptionPane; // Printer "I er nok spillere til at begynde!" og "Vil du tilføje flere spillere?"
    }

    public void removeGui() {
        frame.getContentPane().removeAll();
        frame.setVisible(false);
        frame.repaint();
        frame.dispose();
    }

}

