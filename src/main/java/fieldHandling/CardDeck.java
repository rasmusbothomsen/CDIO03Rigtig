package fieldHandling;

import controllers.TextFileReader;

import java.util.Arrays;
import java.util.Random;


public class CardDeck {

    private final ChanceCard[] cardDeck;
    private int whereInDeck;

    public CardDeck(){
        whereInDeck = 0;
        cardDeck=cardDeckFiller();
        cardShuffler();


    }
    public ChanceCard pullCard() {
        ChanceCard tempCard = cardDeck[whereInDeck];
        whereInDeck++;
        checkWhereInDeck();
        return tempCard;
    }

    private void checkWhereInDeck(){
        if(whereInDeck==cardDeck.length-1){
            cardShuffler();
            whereInDeck=0;
        }
    }

    private ChanceCard[] cardDeckFiller() {
        String[] cardsText = TextFileReader.getChanceCardText();
        int amoutOfUseableText = 0;
        for (String value : cardsText) {
            if (value.startsWith("!!STOP")) {
                break;
            }

            if (value.startsWith("Card")) {
                amoutOfUseableText++;
            }
        }
        ChanceCard[] cards = new ChanceCard[amoutOfUseableText];
        for (int a = 0,b=0; a <cards.length ; a++,b+=2) {
            if(cardsText[b].startsWith("Card")) {
                b++;
                cards[a] = new ChanceCard(cardsText[b], cardsText[b + 1], a);
            }

        }


        return cards;
    }

    @Override
    public String toString() {
        return "CardDeck{" +
                "cardDeck=" + Arrays.toString(cardDeck) +
                '}';
    }

    private void cardShuffler() {
        Random rand = new Random();
        ChanceCard temp;
        for (int i = 0; i < cardDeck.length; i++) {
            int randomIndexSwap = rand.nextInt(cardDeck.length);
            temp = cardDeck[randomIndexSwap];
            cardDeck[randomIndexSwap] = cardDeck[i];
            cardDeck[i] = temp;

        }

    }
}
