package FieldHandling;


public class ChanceCard {
    protected String nameOfCard;
    protected String cardDescription;
    protected int effectOnPlayer;

    public ChanceCard(String nameOfCard, String cardDescription, int effectOnPlayer) {
        this.nameOfCard = nameOfCard;
        this.cardDescription = cardDescription;
        this.effectOnPlayer = effectOnPlayer;
    }

    @Override
    public String toString() {
        return "ChanceCard{" +
                "nameOfCard='" + nameOfCard + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                ", effectOnPlayer=" + effectOnPlayer +
                '}';
    }

    public String getNameOfCard() {
        return nameOfCard;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public int getEffectOnPlayer() {
        return effectOnPlayer;
    }
}
