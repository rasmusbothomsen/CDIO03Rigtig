package FieldHandling;

import Controllers.TextFileReader;

import java.util.Arrays;
import java.util.Random;


public class CardDeck {

    private ChanceCard[] cardDeck;
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
        TextFileReader reader = new TextFileReader("ChanceCardText.txt");
        String[] cardsText = reader.fileReader();
        int amoutOfUseableText = 0;
        for (String s : cardsText) {
            if (s.startsWith("Card")) {
                amoutOfUseableText++;
            }
        }
        ChanceCard[] cards = new ChanceCard[amoutOfUseableText];
        for (int i = 0, a = 0; i < cards.length; i++, a++) {
            if (cardsText[i].startsWith("Card")) {
                a++;
            }
            cards[i] = new ChanceCard(cardsText[a], cardsText[a + 1], i); // Virker ikke helt korrekt

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
