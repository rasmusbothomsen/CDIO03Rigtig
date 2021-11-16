package Objects;

import java.util.Random;

public class Dice {

    private Random dice = new Random();
    private int faceValue;

    public Dice(int faceValue){
        this.faceValue=faceValue;
    }
    public int getDice() {
        int dice1 = dice.nextInt(faceValue)+1;
        return dice1;
    }

}
