package hashtable;

import java.io.*;

public class FileSaver {

    String currentLine;


    {
        try {
            FileReader file = new FileReader("names.csv");
            BufferedReader reader= new BufferedReader(file);
            int counter = 0;
            while ((currentLine = reader.readLine()) != null){
                counter++;
                System.out.println(counter +": " +currentLine);
        }

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
