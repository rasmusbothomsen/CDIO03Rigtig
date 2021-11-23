package Objects;

import TurnHandling.Player;
// for test
public class PlayerCreators {

    public static Player[] createPlayers(){
        Player[] players = new Player[4];
        for(int i =0; i<4;i++){
            players[i]=new Player("Tesst"+i,i);
        }
        return players;
    }
}
