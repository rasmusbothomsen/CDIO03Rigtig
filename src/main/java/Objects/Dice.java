package Objects;

import java.util.Random;

public class Dice {

    private final Random dice = new Random();
    private final int faceValue;

    public Dice(int faceValue){
        this.faceValue=faceValue;
    }
    public int getDice() {
        int dice1 = dice.nextInt(faceValue)+1;
        return dice1;
    }

}
