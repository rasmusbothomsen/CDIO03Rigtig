package controllers;
import turnHandling.Player;

public class Bank {
    private static Player[] players;

    public Bank(Player[] players) {
        Bank.players = players;
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
        for (Player value : players) {
            if (value != player) {
                value.addMoney(amount * -1);
            } else {
                value.addMoney(amount * players.length - 1);
            }
        }

    }

}



