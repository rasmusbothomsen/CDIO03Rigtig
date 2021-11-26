package gUI;

import controllers.TextFileReader;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class IntroGui {
    private JPanel mainPanel;
    private JButton start;
    private JButton exit;
    private JPanel bigPanel;
    private JTextArea text;
    private JLabel gameText;
    private JFrame frame;
    private CountDownLatch latch;

    public IntroGui() {
        frame = new JFrame("Starter");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(600, 600);
        text.append(setLabelText());
        text.setEditable(false);
        frame.add(bigPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        waitForStart();

    }

    private String setLabelText() {
        StringBuilder text = new StringBuilder();
        for (int i = 5; i < 15; i++) {
            text.append(TextFileReader.getGameText()[i]);
            text.append("\n");
        }
        return text.toString();
    }

    private void waitForStart() {
        latch = new CountDownLatch(1);
        start.addActionListener(e -> {
            latch.countDown();
            System.out.println("asdasd");
        });
        exit.addActionListener(e -> {
            latch.countDown();
            System.exit(0);
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        removeGui();
    }

    private void removeGui() {
        frame.getContentPane().removeAll();
        frame.setVisible(false);
        frame.repaint();
        frame.dispose();
    }

}
