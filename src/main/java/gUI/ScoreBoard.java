package gUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

public class ScoreBoard {
    private JTable scoreBoardTable;
    private JPanel scores;
    private JButton playAgain;
    private JButton exit;
    private JScrollPane paneScore;
    private JPanel toplable;
    private JFrame frame;
    private CountDownLatch latch;
    private boolean playgain;

    public ScoreBoard(String[][] textToPrint) {
        scoreBoardTable = new JTable() {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }

            ;
        };
        frame = new JFrame("PlayerCreation");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setResizable(false);
        String[] collumnsName = {"Position", "Player", "Money", "Houses"};
        scoreBoardTable = new JTable(textToPrint, collumnsName);
        scoreBoardTable.setSize(986, 407);
        paneScore.setViewportView(scoreBoardTable);
        frame.add(scores);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        latch = new CountDownLatch(1);


        playAgain.addActionListener(e -> {
            latch.countDown();
            ScoreBoard.this.playgain = true;
        });
        exit.addActionListener(e -> {
            latch.countDown();
            ScoreBoard.this.playgain = false;
            System.exit(0);
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createUIComponents() {

    }

}
