import FieldHandling.Amusement;
import FieldHandling.Board;
import FieldHandling.Chance;
import TurnHandling.Player;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void testIfBoardArrayIsCorrect(){
        Board board = new Board();
        Object[] fieldsTest = board.getFields();
        System.out.println(board);
    }
    @Test
    void testClassEquals(){
        Board board = new Board();
        Object[] fieldsTest = board.getFields();
        System.out.println(fieldsTest[3].getClass().equals(Chance.class));
        System.out.println(fieldsTest[2].getClass().equals(Amusement.class));
        System.out.println(fieldsTest[3].getClass().equals(Chance.class));


        Player[] players = new Player[2];
        players[0]= new Player("Freddy",1);
        players[1]= new Player("Bo",2);
        players[0].getMoney();
        players[1].getMoney();




    }

}