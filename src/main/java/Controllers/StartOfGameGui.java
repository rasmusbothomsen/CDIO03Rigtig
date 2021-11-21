
package Controllers;

        import gui_codebehind.SwingComponentFactory;

        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.KeyEvent;
        import java.awt.event.KeyListener;
        import java.util.concurrent.CountDownLatch;
        import javax.swing.*;


public class StartOfGameGui extends JPanel {
    private JButton danish;
    private JButton english;
    private JButton more;
    private JLabel Iintro;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JLabel jcomp7;


    private  String language;
    private  CountDownLatch latch = new CountDownLatch(1);



    public StartOfGameGui() {
        //construct components
        danish = new JButton("Danish");
        english = new JButton("English");
        more = new JButton("More");
        Iintro = new JLabel("Welcome to Monopoly Junior");
        jcomp5 = new JLabel("Hello and welcome to Monopoly Junior! ");
        jcomp6 = new JLabel("We are very exited to show you the game!");
        jcomp7 = new JLabel("Please first select your language");


        //adjust size and set layout
        setPreferredSize(new Dimension(474, 364));
        setLayout(null);

        //add components
        add(danish);
        add(english);
        add(more);
        add(Iintro);
        add(jcomp5);
        add(jcomp6);
        add(jcomp7);

        //set component bounds (only needed by Absolute Positioning)
        danish.setBounds(105, 275, 100, 20);
        english.setBounds(230, 275, 100, 20);
        more.setBounds(365, 270, 90, 25);
        Iintro.setBounds(155, -10, 240, 75);
        jcomp5.setBounds(10, 80, 475, 25);
        jcomp6.setBounds(10, 105, 460, 35);
        jcomp7.setBounds(10, 175, 235, 30);





    }



    public String getLanguage() {
        final CountDownLatch latch = new CountDownLatch(1);
        JButton danish = new JButton("danish");

        danish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartOfGameGui.this.language = "danish";
                latch.countDown();
            }
        });
        danish.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                StartOfGameGui.this.language="danish";
                latch.countDown();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartOfGameGui.this.language="english";
                System.out.println("Testin");
                latch.countDown();
            }
        });
        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartOfGameGui.this.language="danish";
                latch.countDown();

            }
        });


        try {
            latch.await();
            return StartOfGameGui.this.language;
        } catch (InterruptedException var9) {
            var9.printStackTrace();
            return null;
        }


    }
    private void getFocus(JButton okButton) {
        try {
            Thread.sleep(100L);
            okButton.requestFocusInWindow();
        } catch (InterruptedException var3) {
        }

    }


    public JFrame whatLanguage () {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        StartOfGameGui startOfGameGui = new StartOfGameGui();
        frame.getContentPane().add (startOfGameGui);
        frame.pack();
        frame.setVisible (true);
        return frame;
    }
    public void removeGui(){
        Frame[] frames = JFrame.getFrames();
        for (int i = 0; i < frames.length; i++) {
            frames[i].removeAll();
            frames[i].setVisible(false);

        }

    }
}

