package hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        MyHashTable my = new MyHashTable(20);
        System.out.println(my.getPrimeSize());


        String filePath = "C:\\Users\\Ace\\IdeaProjects\\ADS2\\src\\main\\java\\hashtable\\names.csv";
        String delimiter = " ";
        CSVReader fs =  new CSVReader(filePath, delimiter);
      //  fs.displayCSV();


    }


}
