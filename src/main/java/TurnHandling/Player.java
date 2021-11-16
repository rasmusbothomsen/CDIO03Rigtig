package TurnHandling;

public class Player {
        private final String name;

        private int money;

    public int getPlacementONBoard() {
        return placementONBoard;
    }

    public void setPlacementONBoard(int placementONBoard) {
        this.placementONBoard = placementONBoard;
    }
    public void movePlacementOnBoard(int movedBy){
        this.placementONBoard+=movedBy;
    }

    private int placementONBoard;

        private final int playerNumber;

        public int getPlayerNumber() {
            return this.playerNumber;
        }

        public int getMoney() {
            return this.money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public void addMoney(int point) {
            this.money += point;
        }

        public String getName() {
            return this.name;
        }

        public Player(String name, int playerNumber) {
            this.name = name;
            this.playerNumber = playerNumber;
            this.money = 35;
            this.placementONBoard=0;
        }
    }