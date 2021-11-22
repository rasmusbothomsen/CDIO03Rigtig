package GUI;

import FieldHandling.Amusement;
import FieldHandling.ChanceCard;
import TurnHandling.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

import javax.swing.*;
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
                guiPlayers[i].getCar().setPrimaryColor(players[i].getCarColor());
                gui.addPlayer(guiPlayers[i]);
            }
        }

    }
    public GUIHandler(Player[] players) {
        gui = GUIcreator.guiCreator(Color.pink.darker());
        fields = gui.getFields();
        guiPlayers = new GUI_Player[players.length];
        GUIHandler.players =players;
        createPlayers(players);

    }

    public static void movePlayer(Player player){
        int playerLastPosition = getPlayerPlacement(player.getPlayerNumber());
        removeAndAddRemainingPLayers(player.getPlayerNumber(),playerLastPosition);
        fields[player.getPlacementONBoard()].setCar(guiPlayers[player.getPlayerNumber()],true);
    }
    private static void removeAndAddRemainingPLayers(int playerNumber, int playerLastPosition){
        GUI_Player[] playersOnField= new GUI_Player[guiPlayers.length];
        for(int i =0;i< guiPlayers.length;i++){
            if(i==playerNumber){

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
            ((GUI_Street) fields[player.getPlacementONBoard()]).setHouses(1);
        }

    }
    public static String askMultiple(String question, String... choices){
        return gui.getUserButtonPressed(question,choices);
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
    public static void playerWentToJail(Player player){

    }
    public static boolean askYesOrNo(String question, String choice1, String choice2){
        return gui.getUserLeftButtonPressed(question,choice1,choice2);
    }



}
