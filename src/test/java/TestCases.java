import controllers.GameController;
import controllers.TextFileReader;
import fieldHandling.CardDeck;
import fieldHandling.ChanceCard;
import fieldHandling.EffectFromChanceCardHandler;
import fieldHandling.FieldHandler;
import gUI.PlayerCreation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import turnHandling.Player;

import javax.swing.*;
import java.util.logging.FileHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCases {
    private Player[] players;
    private EffectFromChanceCardHandler effectFromChanceCardHandler;
    private CardDeck cardDeck;

    @BeforeEach
    void setUp() {
        new TextFileReader(".txt");
        players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("test" + i, i);
        }
        effectFromChanceCardHandler = new EffectFromChanceCardHandler();
        cardDeck = new CardDeck();
        new GameController(players);
        GameController.setUpBoard();


    }


    @Test
    void tc01() {
        ChanceCard tempCard = null;
        int moneyBefore = players[1].getMoney();
        String cardDescription = "Du har lavet alle dine lektier. Modtag 2$ fra banken.";
        for (int i = 0; i < 16; i++) {
            tempCard = cardDeck.pullCard();
            if (tempCard.getEffectOnPlayer() == 6) {
                break;
            }
        }
        effectFromChanceCardHandler.applyEffectFromCard(players[1], tempCard);
        boolean isRightDescription = cardDescription.equals(tempCard.getCardDescription());
        boolean isRightName = "Flittig".equals(tempCard.getNameOfCard());
        assertEquals(players[1].getMoney(), moneyBefore + 2);
        assertTrue(isRightDescription);
        assertTrue(isRightName);
        System.out.println(players[1].getMoney());

    }


    @Test
    /** Navnelængdetest - Tester om vi kan taste et navn ind der er længere end +25 bogstaver.
     * Denne test er en boundary test. Så vi har nogle grænseværdier:
     * første test er ved intet input
     * Anden stest er ved input: "/"
     * Tredje test er ved input: "Frederik"
     * Fjerde test er ved input: "Wolfeschlegelsteinhausenbergerdorff"
     */
    void tc02() {
        String[] color = {"Blue", "Yellow", "Black", "White"};

        PlayerCreation playerCreation = new PlayerCreation(color);
        playerCreation.setNameAreaTest("");










    }


    @Test
    /** Felter udenfor array: Vi skal tjekke om programmet giver en fejlemeddelelse når en person lander på et felt på arrayplads over 24.
     * Input til felt array: [>24]
     */
    void tc03() {


    }

    @Test
    /** Ens Pengebeholdning.
     * Der skal testes om den korrekte pengebeholdning starter når vi opretter 2 spillere, 3 spiller og 4 spillere.
     * Det forventede output er:
     * Ved 2 spillere: 20$
     * Ved 3 spillere: 18$
     * Ved 4 spillere: 20$
     */
    void tc04() {

    }


    @Test
        /**  Forskellige pengebeholdninger:
         * Vi laver en boundary test ved forskellige pengebeholdninger hvor vi skal tjekke om programmet giver det korrekte svar.
         * Pengebeholdning 1: (-1)
         * Penegbeholdning 2: (0)
         * Pengebeholdning 3: (2000)
         * Pengebeholdning 4: (2147483650) 
         */
    void tc05() {


    }

}
