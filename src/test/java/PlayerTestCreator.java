import TurnHandling.Player;

public class PlayerTestCreator {
    public static Player[] testPlayers(){
        Player[] players = new Player[4];
        for(int i =0; i<4;i++){
            players[i] = new Player("test"+i,i);
        }
        return players;
    }
}
