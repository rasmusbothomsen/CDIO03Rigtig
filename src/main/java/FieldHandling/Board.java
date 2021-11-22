package FieldHandling;

import Controllers.TextFileReader;

public class Board {


    private  Object[] fields;

    @Override
    public String toString() {
        StringBuilder boardDiscription= new StringBuilder("Fied  1: \t");
        for(int i =0;i<fields.length;i++){
            boardDiscription.append(((Field) fields[i]).getFieldName());
            if(i<fields.length-1) {
                boardDiscription.append("\nField ").append(i + 2).append(":\t");
            }
        }

        return boardDiscription.toString();
    }

    protected  String toClasses(){
        StringBuilder boardDiscription= new StringBuilder("Fied  1: \t");
        for(int i =0;i<fields.length;i++){
            boardDiscription.append(fields[i].getClass());
            if(i<fields.length-1) {
                boardDiscription.append("\nField ").append(i + 2).append(":\t");
            }
        }

        return boardDiscription.toString();
    }

    public Board() {
        fillArrays();
    }
    private void setFieldsColor(String[] pictures){
        for (int i = 0,a=0; i < fields.length; i++) {
            if(getFields()[i].getClass().equals(Amusement.class)){
                ((Amusement)fields[i]).setPictureFile(pictures[a]);
            }
            if(i!=0&&i%2==0){
                a++;
            }

        }
    }
    private  void fillArrays(){
        fields=new Field[24];
        TextFileReader reader = new TextFileReader("FieldsText.txt");
        String[] readFiles = reader.fileReader();
        for(int i =0,a=0; i<readFiles.length&&a<fields.length;i++){
            if(readFiles[i].startsWith("Amusement")){
                ifAmusementToArray(a,readFiles,i+1);
                a++;
            }
            if(readFiles[i].startsWith("Field")){
                ifFieldToArray(a,readFiles,i+1);
                a++;
            }
            if(readFiles[i].startsWith("Chance")){
                ifChanceToArray(a,readFiles,i+1);
                a++;
                i++;
            }
            if(readFiles[i].startsWith("Jail")){
                ifJail(a,readFiles,i+1,readFiles[i+1].startsWith("goTo"));
                a++;
            }


        }


    }
    private  void ifFieldToArray(int arrayToFill,String[] readFiles,int placementRead ) {
        fields[arrayToFill]= new Field(readFiles[placementRead],readFiles[placementRead+1],placementRead);

    }
    private  void ifChanceToArray(int arrayToFill,String[] readFiles,int placementRead){
        fields[arrayToFill]= new Chance(readFiles[placementRead],readFiles[placementRead+1],placementRead);
    }
    private  void ifJail(int arrayToFill, String[] readFiles, int placementRead, boolean goTo){
        if(goTo){
            fields[arrayToFill]= new Jail(readFiles[placementRead+1],readFiles[placementRead+2],placementRead, true);
        }else {
            fields[arrayToFill] = new Jail(readFiles[placementRead], readFiles[placementRead + 1], placementRead, false);
        }
    }

    public  Object[] getFields() {
        return fields;
    }

    private  void ifAmusementToArray(int arrayToFill, String[] readFiles, int placementRead){

            fields[arrayToFill] = new Amusement(readFiles[placementRead], readFiles[placementRead + 1], arrayToFill, Integer.parseInt(readFiles[placementRead + 2]));



    }
}
