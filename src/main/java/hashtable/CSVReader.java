package hashtable;

import java.io.*;
import java.util.Scanner;


public class CSVReader {

   private String filePath;
    private String delimiter;
   // BufferedReader reader;

    public CSVReader(String filePath, String delimiter) throws FileNotFoundException, IOException {

        this.filePath = filePath;
        this.delimiter = delimiter;

    }

    public void displayCSV(){
        BufferedReader reader = null;
        String line;
        delimiter = System.lineSeparator();
        try
        {
           reader  = new BufferedReader(new FileReader(filePath));
            int counter = 0;
            while ((line = reader.readLine()) != null){
               String []values  = line.split(delimiter);
                counter++;
                //System.out.println(counter +":" +line);
                for (String value : values){
                    System.out.println(value+" "+ counter);
                }

            }

        }

        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null)
                reader.close();

            }
            catch (IOException ioe){
                ioe.printStackTrace();
            }
        }



    }
 /* public void displayCSV() {
      try (Scanner scanner = new Scanner(new File(filePath))) {
          int counter = 0;
          if (scanner.hasNextLine()) {
              scanner.nextLine(); // Skip the header row
          }
          while (scanner.hasNextLine()) {
              String line = scanner.nextLine();
              String[] values = line.split(delimiter);
              for (String value : values) {
                  counter++;
                  System.out.println(counter + ": " + value);
              }
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
  }*/

  }




