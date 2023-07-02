package hashtable;


import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
       /* MyHashTable my = new MyHashTable(258001);



        System.out.println("size: "+my.getTABLE_SIZE());
        String filePath = "C:\\Users\\Ace\\IdeaProjects\\ADS2\\src\\main\\java\\hashtable\\names.csv";
        String delimiter = ",";

        my.addCSV(filePath,delimiter);
        my.displayTable();

        System.out.println(my.getSize());



*/


        MyHashTable table = new MyHashTable(200000);
        table.startTheGame();




    }


}
