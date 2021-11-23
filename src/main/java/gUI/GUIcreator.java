package gUI;
import fieldHandling.*;
import gui_fields.*;
import gui_main.GUI;


import java.awt.*;

public class GUIcreator {

    public static GUI guIcreator(Color boardColor) {
        Board board = new Board();
        Object[] fields = board.getFields();
        GUI_Field[] guiFields = fieldsCreator(fields);
        return new GUI(fieldsCreator(fields),boardColor);


    }

    private static GUI_Field[] fieldsCreator(Object[] fieldFromBoard){
        GUI_Field[] guiFields = new GUI_Field[24];
        guiFields[0]= new GUI_Start(((Field)fieldFromBoard[0]).getFieldName(),((Field)fieldFromBoard[0]).getFieldName(),((Field)fieldFromBoard[0]).getFieldDiscription(),Color.WHITE,Color.BLACK);
        for (int i =1; i<fieldFromBoard.length;i++){
                if(fieldFromBoard[i].getClass().equals(Amusement.class)){
                    guiFields[i] = new GUI_shipping(((Amusement)(fieldFromBoard[i])).getPictureFile(),(((Amusement)(fieldFromBoard[i])).getFieldName()), ((Amusement) (fieldFromBoard[i])).getCost() +"$",(((Amusement)(fieldFromBoard[i])).getFieldDiscription()),Integer.toString(((Amusement)(fieldFromBoard[i])).getCost()),Color.WHITE,Color.BLACK);
                }
            if(fieldFromBoard[i].getClass().equals(Chance.class)){
                guiFields[i]= new GUI_Chance("?",((Chance)fieldFromBoard[i]).getFieldName(),"Chance"
                        ,Color.WHITE,Color.BLACK);

            }
            if(fieldFromBoard[i].getClass().equals(Jail.class)){
                guiFields[i]=new GUI_Jail("default",((Field) fieldFromBoard[i]).getFieldName(),((Field) fieldFromBoard[i]).getFieldName(), ((Jail) fieldFromBoard[i]).getFieldDiscription(),Color.WHITE,Color.BLACK);// Printer "Gå til"

            }
            if(fieldFromBoard[i].getClass().equals(Field.class)){
                guiFields[i]=new GUI_Street(((Field)fieldFromBoard[i]).getFieldName(),((Field)fieldFromBoard[i]).getFieldName(),((Field)fieldFromBoard[i]).getFieldDiscription(),"0",Color.WHITE,Color.BLACK);
            }
        }
return guiFields;
    }


}
