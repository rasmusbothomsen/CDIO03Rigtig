package FieldHandling;


import Controllers.GUIHandler;
import TurnHandling.Player;


public class FieldHandler {
    private static CardDeck cardDeck;
    private static Board board;
    private static EffectFromChanceCardHandler chanceCardHandler;

    public FieldHandler() {
        cardDeck = new CardDeck();
        board = new Board();
        chanceCardHandler=new EffectFromChanceCardHandler();
    }
    public static void initiateField(Player player){
        Object[] fields = board.getFields();
        if(fields[player.getPlacementONBoard()].getClass().equals(Amusement.class)){
            isAmusement(player,fields);
        }
        if(fields[player.getPlacementONBoard()].getClass().equals(Chance.class)){
            isChance(player,fields);
        }
        if(fields[player.getPlacementONBoard()].getClass().equals(Jail.class)){
            isRestroom(player,fields);
        }
        if(fields[player.getPlacementONBoard()].getClass().equals(Field.class)){
            isField(player,fields);
        }




    }
    private static void isAmusement(Player player, Object[] fields){
       Amusement amusement= ((Amusement) fields[player.getPlacementONBoard()]);
       if(amusement.isOwned()){
           if(amusement.isAllIsOwned()){
               player.addMoney(amusement.getCost()*-2);
               GUIHandler.printLandedOnOwnedAmusement((Amusement) fields[player.getPlacementONBoard()],player,amusement.getCost()*2);

           }else{
               player.addMoney(amusement.getCost()*-1);
               GUIHandler.printLandedOnOwnedAmusement((Amusement) fields[player.getPlacementONBoard()],player,amusement.getCost());
           }
       }else{
           player.addMoney(amusement.getCost()*-1);
           amusement.setPlayerwhoOwnsIt(player);
           GUIHandler.printLandedOnAmusement((Amusement) fields[player.getPlacementONBoard()],player);
       }
    }
    private static void isChance(Player player, Object[] fields){
        Chance chanceField = (Chance)fields[player.getPlacementONBoard()];
        ChanceCard card = cardDeck.pullCard();
        chanceCardHandler.applyEffectFromCard(player, card);
        GUIHandler.showChanceCard(card);

    }
    private static void isRestroom(Player player, Object[] fields){
        Jail field = (Jail) fields[player.getPlacementONBoard()];
        if(field.isGoTo()){
            player.setPlacementONBoard(18);
            player.addMoney(-3);
            //Mangler resten af denne metode
        }
    }
    private static void isField(Player player,Object[] fields){
        Field field = (Amusement)fields[player.getPlacementONBoard()];
        //Mangler resten af denne her
    }

}
