package objects;

import java.util.Random;

public class Dice {

    private final Random dice = new Random();
    private final int faceValue;

    public Dice(int faceValue){
        this.faceValue=faceValue;
    }
    public int getDice() {
        return dice.nextInt(faceValue)+1;
    }

}
