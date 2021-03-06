package fieldHandling;


import controllers.GameController;
import controllers.TextFileReader;
import gUI.GUIHandler;
import turnHandling.Player;


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
            isChance(player);
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
        if(amusement.getPlayerwhoOwnsIt()==player){
            GUIHandler.printText(TextFileReader.getGameText()[71]);
        } else if(amusement.isOwned()){
           if(amusement.isAllIsOwned()){

                   player.addMoney(amusement.getCost() * -2);
                   GameController.playerPayPlayer(player, amusement.getCost() * 2);
                   GUIHandler.printLandedOnOwnedAmusement(amusement, player, amusement.getCost() * 2);
           }else {
               player.addMoney(amusement.getCost()*-1);
               GameController.playerPayPlayer(player, amusement.getCost());
               GUIHandler.printLandedOnOwnedAmusement(amusement,player,amusement.getCost());
           }
       }else{
           player.addMoney(amusement.getCost()*-1);
           amusement.setPlayerwhoOwnsIt(player);
           GUIHandler.printLandedOnAmusement(amusement,player);
       }
    }
    private static void isChance(Player player){
        ChanceCard card = cardDeck.pullCard();
        GUIHandler.showChanceCard(card);
        chanceCardHandler.applyEffectFromCard(player, card);

    }
    private static void isRestroom(Player player, Object[] fields){
        Jail field = (Jail) fields[player.getPlacementONBoard()];
        if(field.isGoTo()){
            player.setPlacementONBoard(18);
            player.addMoney(-2);
            player.setInJail(true);
            GUIHandler.playerWentToJail(player);
        }else{
            GUIHandler.printText(player.getName()+" "+TextFileReader.getFieldsText()[24]);

        }
    }
    private static void isField(Player player,Object[] fields){
        GUIHandler.printField(((Field)fields[player.getPlacementONBoard()]).getFieldDiscription());
    }
    public static void drawNewChanceCard(Player player){
        ChanceCard card = cardDeck.pullCard();
        chanceCardHandler.applyEffectFromCard(player,card);
        chanceCardHandler.applyEffectFromCard(player, card);

    }
    public static Object getOneField(int placement){
        return board.getFields()[placement];
    }
}
