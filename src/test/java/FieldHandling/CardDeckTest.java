package FieldHandling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void testToString() {
        CardDeck cardDeck = new CardDeck();
        System.out.println(cardDeck);
    }
}