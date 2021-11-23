package TurnHandling;


public class PlayTurn {

    private boolean isBroke;
   private final Player player;
   private final DiceRoller diceRoller;

    public PlayTurn(boolean isBroke, Player player) {
        this.isBroke = isBroke;
        this.player = player;
        diceRoller = new DiceRoller(6);
    }
    protected void changeIsBroke(boolean newStatus){
        this.isBroke=newStatus;
    }


    public void PlayPLayerTurn(){

    }
    public int rollDice(){
        return diceRoller.rollOneDie();
    }

    public int movePlayer(int roll){
        player.movePlacementOnBoard(roll);
        return player.getPlacementONBoard();
    }


}


