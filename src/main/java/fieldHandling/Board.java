package fieldHandling;

import controllers.TextFileReader;

public class Board {


    private  Object[] fields;

    @Override
    public String toString() {
        StringBuilder boardDiscription= new StringBuilder("Field  1: \t");
        for(int i =0;i<fields.length;i++){
            boardDiscription.append(((Field) fields[i]).getFieldName());
            if(i<fields.length-1) {
                boardDiscription.append("\nField ").append(i + 2).append(":\t");
            }
        }

        return boardDiscription.toString();
    }

    public String description() {
        StringBuilder boardDiscription= new StringBuilder("Field  1: \t");
        for(int i =0;i<fields.length;i++){
            boardDiscription.append(((Field) fields[i]).getFieldName()).append("\t");

            boardDiscription.append(((Field) fields[i]).getFieldDiscription());
            if(i<fields.length-1) {
                boardDiscription.append("\nField ").append(i + 2).append(":\t");
            }
        }

        return boardDiscription.toString();
    }

    protected  String toClasses(){
        StringBuilder boardDiscription= new StringBuilder("Field  1: \t");
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
        setFieldsColor(colorsFinder());
    }
    private String[] colorsFinder(){
        String[] colors = new String[8];
        String pathName="src/main/resourcesPictures/";
        colors[0]=pathName+"brun.png";
        colors[1]=pathName+"lyseblå.png";
        colors[2]=pathName+"lilla.png";
        colors[3]=pathName+"orange.png";
        colors[4]=pathName+"rød.png";
        colors[5]=pathName+"gul.png";
        colors[6]=pathName+"grøn.png";
        colors[7]=pathName+"blå.png";
        return colors;
    }
    private void setFieldsColor(String[] pictures){
        for (int i = 0,a=0,c=0; i < fields.length&&c<pictures.length; i++) {
            if(getFields()[i].getClass().equals(Amusement.class)){
                ((Amusement)fields[i]).setPictureFile(pictures[c]);
                a++;
                if(a!=0&&a%2==0){
                    c++;
                }
            }

        }
    }
    private  void fillArrays(){
        fields=new Field[24];
        String[] readFiles = TextFileReader.getFieldsText();
        for(int i =0,a=0,c=1; i<readFiles.length&&a<fields.length;i++){
            if(readFiles[i].startsWith("Amusement")){
                ifAmusementToArray(a,readFiles,i+1,c%2==0);
                a++;
                c++;
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
                i++;
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

    private  void ifAmusementToArray(int arrayToFill, String[] readFiles, int placementRead, boolean isLast){

            fields[arrayToFill] = new Amusement(readFiles[placementRead], readFiles[placementRead + 1], arrayToFill, Integer.parseInt(readFiles[placementRead + 2]));
            if(isLast){
                ((Amusement)fields[arrayToFill]).setSameType(((Amusement)fields[arrayToFill-1]));
                ((Amusement)fields[arrayToFill-1]).setSameType(((Amusement)fields[arrayToFill]));
            }


    }
}
