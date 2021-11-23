import controllers.GameController;
import controllers.TextFileReader;
import fieldHandling.CardDeck;
import fieldHandling.ChanceCard;
import fieldHandling.EffectFromChanceCardHandler;
import fieldHandling.FieldHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import turnHandling.Player;

import java.util.logging.FileHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC01 {
    private Player[] players;
    private EffectFromChanceCardHandler effectFromChanceCardHandler;
    private CardDeck cardDeck;

    @BeforeEach
    void setUp() {
        new TextFileReader(".txt");
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("test"+i,i);
        }
         effectFromChanceCardHandler = new EffectFromChanceCardHandler();
        cardDeck = new CardDeck();

    }

    @Test
    void chanceCard7Test(){
        ChanceCard tempCard = null;
        int moneyBefore = players[1].getMoney();
        String cardDescription= "Du har lavet alle dine lektier. Modtag 2$ fra banken.";
        for (int i = 0; i < 16; i++) {
            tempCard = cardDeck.pullCard();
            if(tempCard.getEffectOnPlayer()==6){
                break;
            }
        }
        effectFromChanceCardHandler.applyEffectFromCard(players[1],tempCard);
        boolean isRightDescription = cardDescription.equals(tempCard.getCardDescription());
        boolean isRightName = "Flittig".equals(tempCard.getNameOfCard());
        assertEquals(players[1].getMoney(),moneyBefore+2);
        assertTrue(isRightDescription);
        assertTrue(isRightName);

    }
}
