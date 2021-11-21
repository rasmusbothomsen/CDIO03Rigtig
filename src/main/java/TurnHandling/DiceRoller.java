package TurnHandling;

import Objects.Dice;

public class DiceRoller {
    private Dice dice;

    public DiceRoller(int faceValue) {
        this.dice = new Dice(faceValue);
    }

    public int rollOneDie(){
        return dice.getDice();
    }

    public int[] rollMultipleDice(int amoutOfDice){
        int[] dices = new int[amoutOfDice];
        for(int i = 0; i< dices.length;i++){
            dices[i]=dice.getDice();
        }
        return dices;
    }

}
