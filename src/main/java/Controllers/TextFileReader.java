package Controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class TextFileReader {
        private final int arrayLenght;
        private final URL resource;
        private File file;

        public TextFileReader(String fileName) {
            this.resource= getClass().getClassLoader().getResource(fileName);
            try {
                this.file = new File((this.resource.toURI()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            this.arrayLenght = this.getFileLength();
        }

        private int getFileLength() {
            int fileLines = 0;

            try {
                for(BufferedReader reader = new BufferedReader(new FileReader(file)); reader.readLine() != null; ++fileLines) {
                }

                return fileLines;
            } catch (IOException var3) {
                var3.printStackTrace();
                return 0;
            }
        }

        private String[] fileReaderPriv() throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentline = reader.readLine();
            String[] allText = new String[this.arrayLenght];

            for(int i = 0; currentline != null && i < allText.length; ++i) {
                allText[i] = currentline;
                currentline = reader.readLine();
            }

            reader.close();
            return allText;
        }

        public String[] fileReader() {
            String[] returnFile = new String[this.arrayLenght];

            try {
                returnFile = this.fileReaderPriv();
            } catch (IOException var3) {
                var3.printStackTrace();
            }

            return returnFile;
        }
    }


