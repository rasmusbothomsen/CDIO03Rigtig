package Controllers;
import TurnHandling.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    private Player[] players;

    public Bank(Player[] players) {
        this.players = players;
    }

    public void affectPlayersBank(int playerNumberOne, int affectAmount) {
        if (playerNumberOne <= players.length) {
            players[playerNumberOne - 1].addMoney(affectAmount);
        }

    }

    public void affectPlayersBank(int playerNumberOne, int affectAmountOfOne, int playerNumberTwo, int affectAmountOfTwo) {
        if (playerNumberOne <= players.length) {
            players[playerNumberOne - 1].addMoney(affectAmountOfOne);

        }
        if (playerNumberTwo <= players.length) {
            players[playerNumberTwo - 1].addMoney(affectAmountOfTwo);

        }
    }

    public void affectPlayersBank(int playerNumberOne, int affectAmountOfOne, int playerNumberTwo, int affectAmountOfTwo, int playerNumberThree, int affectAmountOfThree) {
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

    public void affectPlayersBank(int playerNumberOne, int affectAmountOfOne, int playerNumberTwo, int affectAmountOfTwo, int playerNumberThree, int affectAmountOfThree, int playerNumberFour, int affectAmountOfFour) {
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
}



