package Controllers;

import java.io.*;
import java.util.ArrayList;

public class    TextFileReader {
    private static String[] chanceCardText;

    public static String[] getChanceCardText() {
        return chanceCardText;
    }

    public static String[] getFieldsText() {
        return fieldsText;
    }

    public static String[] getGameText() {
        return gameText;
    }

    private static String[] fieldsText;
    private static String[] gameText;

    public TextFileReader(String language) {
        fileCreator(language);
    }

    private void fileCreator(String language) {
        String file1Name = "/ChanceCardText"+language;
        String file2Name = "/FieldsText"+language;
        String file3Name = "/GameText"+language;
        try {

            InputStream in = getClass().getResourceAsStream(file1Name);
            assert in != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            chanceCardText=fileReaderPriv(reader);

            in = getClass().getResourceAsStream(file2Name);
            assert in != null;
            reader = new BufferedReader(new InputStreamReader(in));
            fieldsText=fileReaderPriv(reader);

            in = getClass().getResourceAsStream(file3Name);
            assert in != null;
            reader = new BufferedReader(new InputStreamReader(in));
            gameText=fileReaderPriv(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    private String[] fileReaderPriv( BufferedReader reader) throws IOException {
        String tempString = reader.readLine();
        ArrayList<String> allText = new ArrayList<>();
        if (tempString!=null) {
            while (tempString!=null) {
                allText.add(tempString);
                tempString = reader.readLine();
            }
        }

        return listToArray(allText);
    }
    private String[] listToArray(ArrayList<String> list){
        String[] returnText= new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            returnText[i]=list.get(i);
        }
        return returnText;
    }
}




