package turnHandling;

import controllers.GameController;
import gUI.GUIHandler;

import java.awt.*;

public class Player {
        private final String name;
        private int money;
        private boolean canSkipJail;
        private Color carColor;
        private int placementONBoard;
        private final int playerNumber;
        private boolean isBroke;


    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.money = 0;
        this.placementONBoard=0;
        canSkipJail=false;
        isBroke=false;
    }
    public Player(String name,String carColor, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.money = 35;
        this.placementONBoard=0;
        canSkipJail=false;
        isBroke=false;
        colorFinder(carColor);
    }

    public boolean isBroke() {
        return isBroke;
    }

    private void colorFinder(String color){
        if(color.startsWith("Red")){
            this.carColor= Color.red;
        }else if(color.startsWith("Blue")){
            this.carColor= Color.blue;

        }else if (color.startsWith("Green")){
            this.carColor= Color.green;

        }
        else if (color.startsWith("Orange")){
            this.carColor= Color.orange;

        } else this.carColor = Color.black;
    }

    public Color getCarColor() {
        return carColor;
    }
    public boolean isCanSkipJail() {
        return canSkipJail;
    }

    public void setCanSkipJail(boolean canSkipJail) {
        this.canSkipJail = canSkipJail;
    }

    public int getPlacementONBoard() {
        return placementONBoard;
    }

    public void setPlacementONBoard(int placementONBoard) {
        if(placementONBoard>=GUIHandler.getFields().length|| placementONBoard<0){
            this.placementONBoard=0;
        }else if(this.placementONBoard>placementONBoard){
            this.placementONBoard = placementONBoard;
            GameController.passStart(this);
        }
        else {

            this.placementONBoard = placementONBoard;
        }
    }

    public void movePlacementOnBoard(int movedBy){
        this.placementONBoard+=movedBy;
        if(placementONBoard>=24){
            placementONBoard=0;
            GameController.passStart(this);
        }
    }


        public int getPlayerNumber() {
            return this.playerNumber;
        }

        public int getMoney() {
            return this.money;
        }

        public void setMoney(int money) {
            this.money = money;
            if(this.money<=0){
                this.money=0;
                this.isBroke=true;
            }
        }

        public void addMoney(int point) {
            this.money += point;
            if(this.money<=0){
                this.isBroke=true;
                this.money=0;
            }

        }

        public String getName() {
            return this.name;
        }
    }