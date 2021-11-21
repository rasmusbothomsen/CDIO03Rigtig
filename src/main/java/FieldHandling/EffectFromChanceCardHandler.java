package FieldHandling;

import Controllers.Bank;
import Controllers.GameController;
import TurnHandling.Player;
import Controllers.GUIHandler;

public class EffectFromChanceCardHandler {
    private Player player;
    private ChanceCard drawnCard;
    public void applyEffectFromCard(Player player, ChanceCard card){
        this.player=player;
        drawnCard=card;
        switch (card.effectOnPlayer){
            case 0:
                effectOne();
                break;
            case 1:
                effectTwo();
                break;
            case 2:
                effectThree();
                break;
            case 3:
                effectFour();
                break;
            case 4:
                effectFive();
                break;
            case 5:
                effectSix();
                break;
            case 6:
                effectSeven();
                break;
            case 7:
                effectEight();
                break;
            case 8:
                effectNine();
                break;
            case 9:
                effectTen();
                break;
            case 10:
                effectEleven();
                break;

            default:
                throw new IllegalStateException("Unexpected value: ");
        }


    }
    private void effectOne(){
        player.setPlacementONBoard(0);
        GameController.passStart(player);
    }
    private void effectTwo(){

        String userChoice = GUIHandler.askMultiple("How far do you want to go?","1","2","3","4","5");
        player.movePlacementOnBoard(Integer.parseInt(userChoice));
        GameController.movePlayer(player);

    }
    private void effectThree(){
        String userChoice = GUIHandler.askMultiple("Move 1 field or draw a new chance card","Move","Draw again");
        if(userChoice.equals("Move")) {
            player.movePlacementOnBoard(1);
            GameController.movePlayer(player);
        }else{
            FieldHandler.drawNewChanceCard(player);
        }
    }
    private void effectFour(){
        player.addMoney(-2);
    }
    private void effectFive(){
        player.setCanSkipJail(true);

    }
    private void effectSix(){
        Bank.allPayOnePlayer(player,1);
    }
    private void effectSeven(){
        player.addMoney(2);
    }
    private void effectEight(){
        player.setPlacementONBoard(23);
        GameController.movePlayer(player);

    }
    private void effectNine(){
        player.setPlacementONBoard(11);
        GameController.movePlayer(player);

    }
    private void effectTen(){
        boolean whatField = GUIHandler.askYesOrNo("Which orange field?",((Field)FieldHandler.getOneField(10)).getFieldName(),((Field)FieldHandler.getOneField(11)).getFieldName());
        if(whatField){
            player.setPlacementONBoard(10);
        }else{
            player.setPlacementONBoard(11);
        }
        if(!((Amusement)FieldHandler.getOneField(player.getPlacementONBoard())).getSameType().isOwned())
        {
            player.addMoney(((Amusement)FieldHandler.getOneField(player.getPlacementONBoard())).getCost());
        }
        GameController.movePlayer(player);
    }
    private void effectEleven(){
        boolean whatField = GUIHandler.askYesOrNo("Which blue field?",((Field)FieldHandler.getOneField(4)).getFieldName(),((Field)FieldHandler.getOneField(5)).getFieldName());
        if(whatField){
            player.setPlacementONBoard(4);
        }else{
            player.setPlacementONBoard(5);
        }
        if(!((Amusement)FieldHandler.getOneField(player.getPlacementONBoard())).getSameType().isOwned())
        {
            player.addMoney(((Amusement)FieldHandler.getOneField(player.getPlacementONBoard())).getCost());
        }
        GameController.movePlayer(player);

    }
    private void effectTwelve(){
        boolean whatField = GUIHandler.askYesOrNo("Which red field?",((Field)FieldHandler.getOneField(13)).getFieldName(),((Field)FieldHandler.getOneField(14)).getFieldName());
        if(whatField){
            player.setPlacementONBoard(13);
        }else{
            player.setPlacementONBoard(14);
        }
        if(!((Amusement)FieldHandler.getOneField(player.getPlacementONBoard())).getSameType().isOwned())
        {
            player.addMoney(((Amusement)FieldHandler.getOneField(player.getPlacementONBoard())).getCost());
        }
        GameController.movePlayer(player);
    }
    private void effectThirteen(){
        if(player.getPlacementONBoard()<10){

        }else if(player.getPlacementONBoard()<19&&player.getPlacementONBoard()>11){

        }

    }

}
