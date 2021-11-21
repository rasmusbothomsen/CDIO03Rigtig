import GUI.PlayerCreation;
import GUI.StartOfGameGui;
import TurnHandling.Player;

public class GuiStart {
    public static Player[] startGuiAndPlayerCreator()  {
        StartOfGameGui startOfGameGui = new StartOfGameGui();
        String language =startOfGameGui.getLanguage();
        startOfGameGui= null;
        return playerCreator();



    }
    private static Player[] playerCreator(){
        Player[] players=new Player[4];
        String[] colors = {"Blue", "Green", "Orange", "Red"};
        PlayerCreation playerCreation = new PlayerCreation(colors);
        for (int i = 0; i < players.length;) {
            if(i>1) {
                if (playerCreation.enoughPlayers() == 1) {
                    break;
                }
            }
            playerCreation.setPlayerInfo();
            if(playerCreation.getPlayerName()!=null&&isUniqe(players,i,playerCreation.getPlayerName())) {
                players[i] = new Player(playerCreation.getPlayerName(), playerCreation.getPlayerColor(), i);
                playerCreation.playerInfoAccepted();
                i++;
            }else if(!isUniqe(players,i,playerCreation.getPlayerName())){
                playerCreation.playerInfoDenied(true);
            }else {
                playerCreation.playerInfoDenied();
            }


        }
        int acctualtLenght=0;
        for (int i = 0; i < players.length; i++) {
            if(players[i]!=null){
                acctualtLenght++;
            }
        }
        Player[] returnPlayers = new Player[acctualtLenght];
        for (int i = 0; i < acctualtLenght; i++) {
            returnPlayers[i]=players[i];

        }
        playerCreation.removeGui();
        playerCreation=null;
       return returnPlayers;
    }
    private static boolean isUniqe(Player[] players , int i, String name){
        for (int j = 0; j < players.length&&players[j]!=null; j++) {
            if(players[j].getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }
}
