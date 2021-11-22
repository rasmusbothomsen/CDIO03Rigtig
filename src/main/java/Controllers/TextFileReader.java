package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class TextFileReader {
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
        URL resource1 = getClass().getClassLoader().getResource("ChanceCardText" + language);
        URL resource2 = getClass().getClassLoader().getResource("FieldsText" + language);
        URL resource3 = getClass().getClassLoader().getResource("GameText" + language);
        File file1;
        File file2;
        File file3;
        try {
            file1 = new File(resource1.toURI());
            chanceCardText=fileReaderPriv(getFileLength(file1),file1);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        try {
            file2 = new File(resource2.toURI());
            fieldsText=fileReaderPriv(getFileLength(file2),file2);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        try {
            file3 = new File(resource3.toURI());
            gameText=fileReaderPriv(getFileLength(file3),file3);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }


    }


    private int getFileLength(File file) {
        int fileLines = 0;

        try {
            for (BufferedReader reader = new BufferedReader(new FileReader(file)); reader.readLine() != null; ++fileLines) {
            }

            return fileLines;
        } catch (IOException var3) {
            var3.printStackTrace();
            return 0;
        }
    }


    private String[] fileReaderPriv(int arrayLenght, File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentline = reader.readLine();
        String[] allText = new String[arrayLenght];

        for (int i = 0; currentline != null && i < allText.length; ++i) {
            allText[i] = currentline;
            currentline = reader.readLine();
        }

        reader.close();
        return allText;


    }
}




