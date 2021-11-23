package turnHandling;


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



    public int rollDice(){
        return diceRoller.rollOneDie();
    }

    public void movePlayer(int roll){
        player.movePlacementOnBoard(roll);
    }


}


