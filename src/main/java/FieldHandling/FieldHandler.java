package FieldHandling;


import TurnHandling.Player;


public class FieldHandler {
    private CardDeck cardDeck;
    private Board board;
    private EffectFromChanceCardHandler chanceCardHandler;

    public FieldHandler() {
        this.cardDeck = new CardDeck();
        this.board = new Board();
        this.chanceCardHandler=new EffectFromChanceCardHandler();
    }
    public void initiateField(Player player){
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
    private void isAmusement(Player player, Object[] fields){
       Amusement amusement= ((Amusement) fields[player.getPlacementONBoard()]);
       if(amusement.isOwned()){
           if(amusement.isAllIsOwned()){
               player.addMoney(amusement.getCost()*-2);
           }else{
               player.addMoney(amusement.getCost()*-1);
           }
       }else{
           player.addMoney(amusement.getCost()*-1);
           amusement.setPlayerwhoOwnsIt(player);
       }
    }
    private void isChance(Player player, Object[] fields){
        Chance chanceField = (Chance)fields[player.getPlacementONBoard()];
        chanceCardHandler.applyEffectFromCard(player, cardDeck.pullCard());

    }
    private void isRestroom(Player player, Object[] fields){
        Jail field = (Jail) fields[player.getPlacementONBoard()];
        if(field.isGoTo()){
            player.setPlacementONBoard(18);
            player.addMoney(-3);
            //Mangler resten af denne metode
        }
    }
    private void isField(Player player,Object[] fields){
        Field field = (Amusement)fields[player.getPlacementONBoard()];
        //Mangler resten af denne her
    }

}
