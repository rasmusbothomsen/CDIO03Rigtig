package controllers;

import fieldHandling.Amusement;
import fieldHandling.FieldHandler;
import gUI.GUIHandler;
import gUI.GUI_shipping;
import turnHandling.PlayTurn;
import turnHandling.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Shipping;

public class GameController {
    private static PlayTurn[] playTurn;
    private static Player[] players;
    private static int nextPlayersTurn;

    public GameController(Player[] players) {
        GameController.players =players;
        new GUIHandler(players);
        playTurn= new PlayTurn[players.length];
        FieldHandler fieldHandler = new FieldHandler();
        new Bank(players);
        initiatePlayturn();
    }
    private static void initiatePlayturn(){
        for(int i = 0;i<playTurn.length;i++){
            playTurn[i]=new PlayTurn(false,players[i]);
        }
    }




//alle tekst elementerne er placeholders
    public static void startOFGame(){
    GUIHandler.printText(players[0].getName()+TextFileReader.getGameText()[20]);// Printer "'s tur rul for at se om du start"
   int[] rolls = startOfGameThrows(players);
    int[][] comparedThrows= compareThrows(rolls);
    int throwIsSame=0;
        for (int i = 0; i < rolls.length-1; i++) {
            if(comparedThrows[i][0]==comparedThrows[comparedThrows.length-1][0]){
                throwIsSame++;
            }
        }
        if(throwIsSame>0) {
            rollAgain(throwIsSame);
            return;
        }
        setStartingPlayer(comparedThrows);
    }
    private static void setStartingPlayer(int[][] playersRoll){
        nextPlayersTurn=playersRoll[playersRoll.length-1][1];
    }
    private static int[] startOfGameThrows(Player[] playersToThrow){
        int[] rolls=new int[playersToThrow.length];
        for (int i = 0; i<playersToThrow.length;i++) {
            GUIHandler.askToRoll(playersToThrow[i].getName()+TextFileReader.getGameText()[23]); // Printer  "'s tur - Tryk på rul for at kaste med terningen"
            rolls[i]=playTurn[i].rollDice();
            GUIHandler.showDiceRoll(rolls[i]);
            GUIHandler.printText(playersToThrow[i].getName()+" "+ TextFileReader.getGameText()[70] +" "+ rolls[i]+"!"); // Printer "rullede"
        }
        return rolls;
    }
    private static void rollAgain(int amoutSame){
        Player[] playersToRollAgain = new Player[amoutSame];
        for (int a = players.length-1, b=0; b <= amoutSame; a--,b++) {
            playersToRollAgain[b]=players[a];
        }
        StringBuilder rollAgainText = new StringBuilder();
        for (int a = 0, i =0; i < amoutSame; i++) {
        rollAgainText.append(playersToRollAgain[a].getName());
            if (i<amoutSame-1){
                rollAgainText.append(", ");
            }else{
                rollAgainText.append(TextFileReader.getGameText()[60]); // Printer "og rullede det samme, rul igen
            }
        }
        GUIHandler.printText(rollAgainText.toString());
        startOfGameThrows(playersToRollAgain);
    }
    public static void passStart(Player player){
        player.addMoney(2);
        GUIHandler.movePlayer(player);
        GUIHandler.printText(player.getName()+TextFileReader.getGameText()[62]); // Printer "Passerede start, modtag 2$"


    }
    protected static int[][] compareThrows(int[] rolls){
        int[][] playerRolls = new int[rolls.length][2];
        for (int i = 0; i < rolls.length; i++) {
            playerRolls[i][0]=rolls[i];
            playerRolls[i][1]=i;
        }
        for(int i =0;i<rolls.length-1;i++){
            int tempRoll;
            int tempPlayer;
            if(playerRolls[i][0]>playerRolls[i+1][0]){
                tempRoll=playerRolls[i+1][0];
                tempPlayer=playerRolls[i+1][1];
                playerRolls[i+1][0]=playerRolls[i][0];
                playerRolls[i+1][1]=playerRolls[i][1];
                playerRolls[i][0]=tempRoll;
                playerRolls[i][1]=tempPlayer;
            }
        }
        return playerRolls;
    }
    public static void setUpBoard(){
        for (Player value : players) {
            value.setPlacementONBoard(0);
            GUIHandler.movePlayer(value);
        }
        int startingMoney = 20;
        switch (players.length) {
            case 2 -> startingMoney = 20;
            case 3 -> startingMoney = 18;
            case 4 -> startingMoney = 16;
            default ->  {
            }
        }
        for (Player player : players) {
            player.setMoney(startingMoney);

        }
        GUIHandler.createPlayers(players);
    }
    public static void playOneTurn(){
    int diceroll = playTurn[nextPlayersTurn].rollDice();
        GUIHandler.askToRoll(players[nextPlayersTurn].getName()+TextFileReader.getGameText()[23]); // Printer "'s tur - Tryk på rul for at kaste med terningen"
        GUIHandler.showDiceRoll(diceroll);
        GUIHandler.printText(players[nextPlayersTurn].getName()+ TextFileReader.getGameText()[70] +" "+ diceroll+"!");
        playTurn[nextPlayersTurn].movePlayer(diceroll);
        GUIHandler.movePlayer(players[nextPlayersTurn]);
        FieldHandler.initiateField(players[nextPlayersTurn]);
        addOneToNextPlaer();

    }
    public static void playOneExtraTurn(){
        nextPlayersTurn -= 1;
        int diceroll = playTurn[nextPlayersTurn].rollDice();
        playTurn[nextPlayersTurn].movePlayer(diceroll);
        GUIHandler.movePlayer(players[nextPlayersTurn]);
        FieldHandler.initiateField(players[nextPlayersTurn]);
        addOneToNextPlaer();

    }
    public static Player returnIfPlayerBroke(){
        for (Player player : players) {
            if (player.isBroke()) {
                return player;
            }

        }
        return null;
    }
    public static Player[] comparePlayerMoney(){
        Player[] comparedPlayers = players;
        Player tempPlayer;
        for (int i = 0; i < players.length-1; i++) {
            if(comparedPlayers[i].getMoney()>comparedPlayers[i+1].getMoney()){
                tempPlayer=comparedPlayers[i+1];
                comparedPlayers[i+1]=comparedPlayers[i];
                comparedPlayers[i]=tempPlayer;

            }
        }
        return comparedPlayers;
    }
    public static void movePlayer(Player player){
        GUIHandler.movePlayer(player);
        FieldHandler.initiateField(player);
    }
    public static void getFreeField(Player player){
        Amusement amusement = (Amusement) FieldHandler.getOneField(player.getPlacementONBoard());
        int tempCost= amusement.getCost();
        amusement.setCost(0);
        FieldHandler.initiateField(player);
        amusement.setCost(tempCost);
        GUIHandler.movePlayer(player);

    }
    private static void addOneToNextPlaer(){
        nextPlayersTurn++;
        if(nextPlayersTurn>=players.length){
            nextPlayersTurn=0;
        }
    }
    public static void upDatePlayerBalance(){
        GUIHandler.upDatePlayerBalance();
    }
    public static String getPlayerHouses(Player player){
        GUI_Field[] fields = GUIHandler.getFields();
        int houses=0;
        for (int i = 0; i < GUIHandler.getFields().length; i++) {
            if(fields[i].getClass().equals(GUI_Shipping.class)){
                if (((GUI_Shipping)fields[i]).getOwnerName().equals(player.getName())){
                houses++;
                }
            }

        }
        return Integer.toString(houses) ;
    }
    public static void playerPayPlayer(Player player, int amount){
        String playerWhoGetsName = ((GUI_shipping)GUIHandler.getFields()[player.getPlacementONBoard()]).getOwnerName();
        for (Player value : players) {

            if (playerWhoGetsName.equals(value.getName())) {
                value.addMoney(amount);
                break;
            }
        }

    }

}
