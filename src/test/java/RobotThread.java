import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class RobotThread implements Runnable {

    @Override
    public void run() {
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        while(!Thread.currentThread().isInterrupted()){
            bot.delay(100);
            bot.keyPress(10);
            bot.delay(100);
            bot.keyRelease(10);
        }
    }
}
