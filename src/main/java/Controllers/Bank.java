package Controllers;
import TurnHandling.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    private static Player[] players;

    public Bank(Player[] players) {
        this.players = players;
    }

    public static void affectPlayersBank(int playerNumberOne, int affectAmount) {
        if (playerNumberOne <= players.length) {
            players[playerNumberOne - 1].addMoney(affectAmount);
        }

    }

    public static void affectPlayersBank(int playerNumberOne, int affectAmountOfOne, int playerNumberTwo, int affectAmountOfTwo) {
        if (playerNumberOne <= players.length) {
            players[playerNumberOne - 1].addMoney(affectAmountOfOne);

        }
        if (playerNumberTwo <= players.length) {
            players[playerNumberTwo - 1].addMoney(affectAmountOfTwo);

        }
    }

    public static void affectPlayersBank(int playerNumberOne, int affectAmountOfOne, int playerNumberTwo, int affectAmountOfTwo, int playerNumberThree, int affectAmountOfThree) {
        if (playerNumberOne <= players.length) {
            players[playerNumberOne - 1].addMoney(affectAmountOfOne);

        }
        if (playerNumberTwo <= players.length) {
            players[playerNumberTwo - 1].addMoney(affectAmountOfTwo);

        }
        if (playerNumberTwo <= players.length) {
            players[playerNumberThree - 1].addMoney(affectAmountOfThree);

        }
    }

    public static void affectPlayersBank(int playerNumberOne, int affectAmountOfOne, int playerNumberTwo, int affectAmountOfTwo, int playerNumberThree, int affectAmountOfThree, int playerNumberFour, int affectAmountOfFour) {
        if (playerNumberOne <= players.length) {
            players[playerNumberOne - 1].addMoney(affectAmountOfOne);

        }
        if (playerNumberTwo <= players.length) {
            players[playerNumberTwo - 1].addMoney(affectAmountOfTwo);

        }
        if (playerNumberTwo <= players.length) {
            players[playerNumberThree - 1].addMoney(affectAmountOfThree);
        }
        if (playerNumberTwo <= players.length) {
            players[playerNumberFour - 1].addMoney(affectAmountOfFour);
        }
    }
    public static void allPayOnePlayer(Player player, int amount){
        for (int i = 0; i < players.length; i++) {
            if(players[i]!=player){
                players[i].addMoney(amount*-1);
            }else {
                players[i].addMoney(amount*players.length-1);
            }
        }

    }

}



