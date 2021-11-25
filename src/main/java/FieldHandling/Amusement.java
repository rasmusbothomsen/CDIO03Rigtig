package FieldHandling;

import TurnHandling.Player;

public class Amusement extends Field {
    private int cost;
    private Player playerwhoOwnsIt;
    private  boolean isOwned;
    private  boolean allIsOwned;

    private String pictureFile;


    private Amusement sameType;

    public String getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(String pictureFile) {
        this.pictureFile = pictureFile;
    }

    @Override
    public String toString() {
        return "Amusement{" +
                "cost=" + cost +
                ", playerwhoOwnsIt=" + playerwhoOwnsIt +
                ", isOwned=" + isOwned +
                ", allIsOwned=" + allIsOwned +
                ", sameType=" + sameType +
                '}';
    }

    public Amusement(String fieldName, String fieldDiscription, int placementOnBoard,
                     int cost) {
        super(fieldName, fieldDiscription, placementOnBoard);
        this.cost = cost;
        this.isOwned = false;
        this.allIsOwned = false;
    }

    public void setSameType(Amusement sameType) {
        this.sameType = sameType;
    }

    public int getCost() {
        return cost;
    }

    public void setPlayerwhoOwnsIt(Player playerwhoOwnsIt) {
        this.playerwhoOwnsIt = playerwhoOwnsIt;
        this.isOwned=true;
        if(sameType.isOwned){
            this.allIsOwned=true;
            sameType.allIsOwned=true;
        }
    }

    public Player getPlayerwhoOwnsIt() {
        return playerwhoOwnsIt;
    }

    public Amusement getSameType() {
        return sameType;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public boolean isAllIsOwned() {
        return allIsOwned;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
