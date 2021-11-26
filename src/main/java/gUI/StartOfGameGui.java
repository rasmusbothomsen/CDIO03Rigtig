package gUI;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

public class StartOfGameGui extends JFrame {
    protected JPanel mainPanel;
    protected JButton danish;
    protected JButton englishButton;
    protected JButton moreButton;
    private JFrame frame;
    private CountDownLatch latch;
    private String language;

    public StartOfGameGui() {
        frame = new JFrame("Starter");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setResizable(false);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public String getLanguage() {

        latch = new CountDownLatch(1);
        danish.addActionListener(e -> {
            language = ".txt";
            latch.countDown();

        });
        englishButton.addActionListener(e -> {
            language = "ENG.txt";

            latch.countDown();

        });
        moreButton.addActionListener(e -> {
            language = ".txt";

            latch.countDown();

        });

        try {
            latch.await();
            removeGui();
            return language;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        removeGui();
        return null;
    }

    private void removeGui() {
        frame.getContentPane().removeAll();
        frame.setVisible(false);
        frame.repaint();
        dispose();
    }

    private void createUIComponents() {
    }


}
