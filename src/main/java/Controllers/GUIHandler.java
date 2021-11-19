package Controllers;

import FieldHandling.Amusement;
import FieldHandling.ChanceCard;
import FieldHandling.Field;
import TurnHandling.Player;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class GUIHandler {
    private static GUI_Field[] fields;
    private static GUI gui;
    private static GUI_Player[] guiPlayers;
    private static Player[] players;


    private static void createPlayers(Player[] players){
        for(int i =0; i< players.length;i++){
            if(players[i]!=null){
                guiPlayers [i]= new GUI_Player(players[i].getName(),players[i].getMoney());
                gui.addPlayer(guiPlayers[i]);
            }
        }
    }
    public GUIHandler(Player[] players) {
        gui = GUIcreator.guiCreator(Color.pink.darker());
        fields = gui.getFields();
        guiPlayers = new GUI_Player[players.length];
        this.players=players;
        createPlayers(players);

    }

    public static void movePlayer(Player player){
        int playerLastPosition = getPlayerPlacement(player.getPlayerNumber()-1);
        removeAndAddRemainingPLayers(player.getPlayerNumber(),playerLastPosition);
        fields[player.getPlacementONBoard()-1].setCar(guiPlayers[player.getPlayerNumber()-1],true);
    }
    private static void removeAndAddRemainingPLayers(int playerNumber, int playerLastPosition){
        GUI_Player[] playersOnField= new GUI_Player[guiPlayers.length];
        for(int i =0;i< guiPlayers.length;i++){
            if(i==playerNumber-1){

            }else if (fields[playerLastPosition].hasCar(guiPlayers[i])){
                playersOnField[i]=guiPlayers[i];
            }
        }
        fields[playerLastPosition].removeAllCars();
        for(int i =0;i<playersOnField.length;i++){
            if(playersOnField[i]!=null){
                fields[playerLastPosition].setCar(playersOnField[i],true);
            }
        }
    }
    private static int getPlayerPlacement(int playerNumber){
        for(int i = 0; i< fields.length;i++){
            if(fields[i].hasCar(guiPlayers[playerNumber])){
                return i;
            }
        }
        return 0;
    }
    public static void showDiceRoll(int diceRoll){
        gui.setDie(diceRoll);
    }
    public static void showChanceCard(ChanceCard chanceCard){
        gui.displayChanceCard(chanceCard.getCardDescription());
    }
    public static void addHouseToField(Player player){
        if(fields[player.getPlacementONBoard()].getClass().equals(GUI_Street.class)) {
            ((GUI_Street) fields[player.getPlacementONBoard()]).setOwnerName(player.getName());
            ((GUI_Street) fields[player.getPlacementONBoard()]).setHotel(true);
        }

    }
    public static boolean addChoice(String firstChoice, String secondChoice, String description){
        return gui.getUserLeftButtonPressed(description,firstChoice,secondChoice);
    }
    public static void askToRoll( String ask){
        gui.getUserButtonPressed(ask,"Roll");
    }
    public static void printText(String textToPrint){
        gui.showMessage(textToPrint);
    }
    public static void printField(int fieldPlacement){

    }
    public static void printLandedOnAmusement(Amusement field, Player playerWhoIsOnField){
        addHouseToField(playerWhoIsOnField);
        printText("You landed on "+field.getFieldName()+" You bought the field for "+field.getCost()+"$" );
        upDatePlayerBalance();
    }
    public static void printLandedOnOwnedAmusement(Amusement field, Player playerWhoIsOnField, int amountPayed){
        printText("You landed on "+field.getPlayerwhoOwnsIt().getName()+"'s field pay "+amountPayed+"$");
        upDatePlayerBalance();
    }
    private static void upDatePlayerBalance(){
        for (int i = 0; i < guiPlayers.length; i++) {
            guiPlayers[i].setBalance(players[i].getMoney());

        }
    }



}
