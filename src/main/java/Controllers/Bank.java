package Controllers;
import TurnHandling.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    private Player[] players;

    public Bank(Player[] players){
        this.players=players;
    }

    public void affectPlayersBank(int playerNumberOne, int affectAmount){
        if(playerNumberOne<=players.length) {
            players[playerNumberOne-1].addMoney(affectAmount);
        }

    }
    public void affectPlayersBank(int playerNumberOne,int affectAmountOfOne, int playerNumberTwo,int affectAmountOfTwo){

    }
    public void affectPlayersBank(int playerNumberOne,int affectAmountOfOne,int playerNumberTwo,int affectAmountOfTwo, int playerNumberThree,int affectAmoutOfThree){

    }
    public void affectPlayersBank(int playerNumberOne,int affectAmountOfOne,int playerNumberTwo,int affectAmountOfTwo, int playerNumberThree,int affectAmoutOfThree, int playerNumberFour,int affectAmoutOfFour){

    }


}

