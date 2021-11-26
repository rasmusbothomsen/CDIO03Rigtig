import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.awt.event.InputEvent.BUTTON1_DOWN_MASK;

public class RobotTyperThread implements Runnable {
    private int stringLength;



    public RobotTyperThread(int stringLength) {

        this.stringLength=stringLength;

    }


    @Override
    public void run() {
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
       // while(!Thread.currentThread().isInterrupted()){

                bot.mouseMove(400, 450);
                bot.mousePress(BUTTON1_DOWN_MASK);
                bot.delay(100);
                bot.mouseRelease(BUTTON1_DOWN_MASK);


                for (int i = 0; i <= stringLength; i++) {
                    bot.keyPress(65);
                    bot.delay(100);
                    bot.keyRelease(65);
                }
        bot.mouseMove(400, 490);
        bot.mousePress(BUTTON1_DOWN_MASK);
        bot.delay(100);
        bot.mouseRelease(BUTTON1_DOWN_MASK);
          //  }

        }
    }


