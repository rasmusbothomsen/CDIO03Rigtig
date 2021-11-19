package FieldHandling;

import TurnHandling.Player;
import Controllers.GUIHandler;

public class EffectFromChanceCardHandler {
    private Player player;
    private ChanceCard drawnCard;
    public String[] applyEffectFromCard(Player player, ChanceCard card){
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
        return null;

    }
    private void effectOne(){
        player.setPlacementONBoard(0);
        player.addMoney(2);
        GUIHandler.showChanceCard(drawnCard);
    }
    private void effectTwo(){
        player.movePlacementOnBoard(5);


    }
    private void effectThree(){
        player.movePlacementOnBoard(1);
        // eller nedenstående
        // træk nyt kort
    }
    private void effectFour(){
        player.addMoney(-2);
    }
    private void effectFive(){
        //løslades uden omkostninger, gem til senere

    }
    private void effectSix(){
      // alle spillere skal betale spilleren 1$
    }
    private void effectSeven(){
        player.addMoney(2);
    }
    private void effectEight(){
        player.setPlacementONBoard(23);
    }
    private void effectNine(){
        player.setPlacementONBoard(11);
    }
    private void effectTen(){
        // jeg ved ikke hvad der er det orange felt
    }
    private void effectEleven(){

    }

}
