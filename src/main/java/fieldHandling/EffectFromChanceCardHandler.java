package fieldHandling;

import controllers.Bank;
import controllers.GameController;
import controllers.TextFileReader;
import turnHandling.Player;
import gUI.GUIHandler;

public class EffectFromChanceCardHandler {
    private Player player;

    public void applyEffectFromCard(Player player, ChanceCard card) {
        this.player = player;
        switch (card.effectOnPlayer) {
            case 0 -> effectOne();
            case 1 -> effectTwo();
            case 2 -> effectThree();
            case 3 -> effectFour();
            case 4 -> effectFive();
            case 5 -> effectSix();
            case 6 -> effectSeven();
            case 7 -> effectEight();
            case 8 -> effectNine();
            case 9 -> effectTen();
            case 10 -> effectEleven();
            case 11 -> effectTwelve();
            case 12 -> effectThirteen();
            case 13 -> effectFourteen();
            case 14 -> effectFifteen();
            case 15 -> effectSixteen();
            default -> throw new IllegalStateException("Unexpected value: ");
        }


    }

    private void effectOne() {
        player.setPlacementONBoard(0);
        GameController.passStart(player);
    }

    private void effectTwo() {

        String userChoice = GUIHandler.askMultiple(TextFileReader.getChanceCardText()[48], "1", "2", "3", "4", "5");// Printer Hvor langt vil du rykke?
        player.movePlacementOnBoard(Integer.parseInt(userChoice));
        GameController.movePlayer(player);

    }

    private void effectThree() {
        String userChoice = GUIHandler.askMultiple(TextFileReader.getChanceCardText()[8], TextFileReader.getChanceCardText()[49], TextFileReader.getChanceCardText()[50]); //Printer "Ryk 1 felt frem, eller træk et chance kort mere.", "Ryk", "Træk igen"
        if (userChoice.equals(TextFileReader.getChanceCardText()[49])) { // Printer "Ryk"
            player.movePlacementOnBoard(1);
            GameController.movePlayer(player);
        } else {
            FieldHandler.drawNewChanceCard(player);
        }
    }

    private void effectFour() {
        player.addMoney(-2);
    }

    private void effectFive() {
        player.setCanSkipJail(true);

    }

    private void effectSix() {
        Bank.allPayOnePlayer(player, 1);
    }

    private void effectSeven() {
        player.addMoney(2);
    }

    private void effectEight() {
        player.setPlacementONBoard(23);
        GameController.movePlayer(player);

    }

    private void effectNine() {
        player.setPlacementONBoard(11);
        GameController.movePlayer(player);

    }

    private void effectTen() {
        boolean whatField = GUIHandler.askYesOrNo(TextFileReader.getChanceCardText()[51], ((Field) FieldHandler.getOneField(10)).getFieldName(), ((Field) FieldHandler.getOneField(11)).getFieldName());
        if (whatField) { // Printer "Hvilket orange felt?"
            player.setPlacementONBoard(10);
        } else {
            player.setPlacementONBoard(11);
        }
       freeField();
    }

    private void effectEleven() {
        boolean whatField = GUIHandler.askYesOrNo(TextFileReader.getChanceCardText()[52], ((Field) FieldHandler.getOneField(4)).getFieldName(), ((Field) FieldHandler.getOneField(5)).getFieldName());
        if (whatField) { // Printer "Hvilket blå felt?"
            player.setPlacementONBoard(4);
        } else {
            player.setPlacementONBoard(5);
        }
        freeField();

    }

    private void effectTwelve() {
        boolean whatField = GUIHandler.askYesOrNo(TextFileReader.getChanceCardText()[53], ((Field) FieldHandler.getOneField(13)).getFieldName(), ((Field) FieldHandler.getOneField(14)).getFieldName());
        if (whatField) { // Printer "Hvilket rødt felt?"
            player.setPlacementONBoard(13);
        } else {
            player.setPlacementONBoard(14);
        }
        freeField();
    }

    private void effectThirteen() {
        if(player.getPlacementONBoard()<20&&player.getPlacementONBoard()>=11){
            if(player.getPlacementONBoard()==19){
                player.movePlacementOnBoard(1);
            }else {
                player.setPlacementONBoard(19);
            }
        } else{
            if(player.getPlacementONBoard()==10){
                player.movePlacementOnBoard(1);
            }else{
                player.setPlacementONBoard(10);
            }
        }
        freeField();
    }
    private void effectFourteen() {
        if(player.getPlacementONBoard()<23&&player.getPlacementONBoard()>=8){
            if(player.getPlacementONBoard()==22){
                player.movePlacementOnBoard(1);
            }else {
                player.setPlacementONBoard(22);
            }
        } else{
            if(player.getPlacementONBoard()==7){
                player.movePlacementOnBoard(1);
            }else{
                player.setPlacementONBoard(7);
            }
        }
        freeField();
    }
    private void effectFifteen() {
        if(player.getPlacementONBoard()<14&&player.getPlacementONBoard()>=5){
            if(player.getPlacementONBoard()==13){
                player.movePlacementOnBoard(1);
            }else {
                player.setPlacementONBoard(13);
            }
        } else{
            if(player.getPlacementONBoard()==4){
                player.movePlacementOnBoard(1);
            }else{
                player.setPlacementONBoard(4);
            }
        }
        freeField();
    }
    private void effectSixteen() {
        if(player.getPlacementONBoard()<17&&player.getPlacementONBoard()>=2){
            if(player.getPlacementONBoard()==16){
                player.movePlacementOnBoard(1);
            }else {
                player.setPlacementONBoard(16);
            }
        } else{
            if(player.getPlacementONBoard()==1){
                player.movePlacementOnBoard(1);
            }else{
                player.setPlacementONBoard(1);
            }
        }
        freeField();
    }
    private void freeField(){
        if (!((Amusement) FieldHandler.getOneField(player.getPlacementONBoard())).isOwned()){
            GameController.getFreeField(player);
        }else {
            GameController.movePlayer(player);
        }

    }
}
