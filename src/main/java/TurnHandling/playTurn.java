package TurnHandling;


public class playTurn {

    private boolean isBroke;
   private Player player;
   private DiceRoller diceRoller;

    public playTurn(boolean isBroke, Player player, DiceRoller diceRoller) {
        this.isBroke = isBroke;
        this.player = player;
        this.diceRoller = diceRoller;
    }
    protected void changeIsBroke(boolean newStatus){
        this.isBroke=newStatus;
    }
}


