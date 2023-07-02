package hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyHashTable implements CRDMethods<Integer, String> {
    private int TABLE_SIZE;
    private int size;
    private HashEntry[] table;
    private int primeSize;
    private static final String NEWLINE = System.getProperty("line.separator");

    public int getTABLE_SIZE() {
        return TABLE_SIZE;
    }

    public int getSize() {
        return size;
    }

    public HashEntry[] getTable() {
        return table;
    }

    public int getPrimeSize() {
        for (int i = TABLE_SIZE - 1; i >= 1; i--) {
            int primeCounter = 0;
            for (int j = 2; j * j <= i; j++)
                if (i % j == 0) primeCounter++;
            if (primeCounter == 0) return i;

        }
        return 3;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        size = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }


    public MyHashTable(int capacity) {
        size = 0;
        TABLE_SIZE = capacity;
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
        primeSize = getPrimeSize();

    }


    private int firstHash(Integer hashValue) {
        int firstHashValue = hashValue.hashCode();
        firstHashValue %= TABLE_SIZE;
        if (firstHashValue < 0) {
            firstHashValue += TABLE_SIZE;
        }
        return firstHashValue;
    }

    private int secondHash(Integer hashValue2) {
        int secondHashValue = hashValue2.hashCode();
        secondHashValue %= TABLE_SIZE;
        if (secondHashValue < 0) {
            secondHashValue += TABLE_SIZE;
        }
        return primeSize - secondHashValue % primeSize;
    }


    @Override
    public void put(Integer key, String value) {
        if (key == null)
            throw new IllegalArgumentException(Color.BLUE+"Key can not be Null"+Color.RESET);
        if (size == TABLE_SIZE) {
            System.out.println(Color.BLUE+"Table is full"+Color.RESET);
            return;
        }

        int firstHash = firstHash(key);
        int secondHash = secondHash(key);
        int i = 1;
        while (table[firstHash] != null) {
            if (table[firstHash].getKey().equals(key)) {
                // Key already exists, update the value or handle accordingly
                table[firstHash].setValue(value);
                return;
            }
            firstHash = (firstHash + i * secondHash) % TABLE_SIZE;
            i++;
        }
        table[firstHash] = new HashEntry(key, value);
        size++;

    }

    @Override
    public void remove(Integer key) {

        int firstHashVal = firstHash(key);
        int secondHashVal = secondHash(key);

        while (table[firstHashVal] != null && !table[firstHashVal].getKey().equals(key)){
            firstHashVal += secondHashVal;
            firstHashVal %= TABLE_SIZE;
        }
        if (table[firstHashVal] != null) {
            table[firstHashVal] = null;
            size--;
        }
    }

    @Override
    public String find(Integer key) {
        int firstHash = firstHash(key);
        int secondHash = secondHash(key);

        while (table[firstHash] != null && !table[firstHash].getKey().equals(key)) {
            firstHash += secondHash;
            firstHash %= TABLE_SIZE;
        }
        if (table[firstHash] != null) {
            return table[firstHash].getValue().toString();
        }
        return Color.BLUE+"Value not there"+Color.RESET;
    }

    public String findValueInList(String value){

            for (HashEntry entry : table) {
                if (entry != null) {
                    if (entry.getValue() == null && value == null) {
                        return entry.getValue().toString() + "Name not found";
                    } else if (entry.getValue() != null && entry.getValue().equals(value)) {
                        return Color.BLUE+"Name is in the list: "+entry.getValue().toString() + Color.RESET;
                    }
                }
            }
                return null;
    }


    @Override
    public void displayTable() {
       System.out.println(Color.GREEN_UNDERLINED+"Hash-Table"+Color.RESET);

        for (int i = 0 ; i < TABLE_SIZE; i++){
            if(table[i] != null) {

                System.out.printf("Key: %-15d Value: %-15s\n", table[i].getKey(), table[i].getValue());
            }
        }
    }

    public void addCSV(String filePath, String delimiter){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            String [] names = new String[TABLE_SIZE];
            while ((line = reader.readLine()) != null) {
                String name = line.trim();

                boolean isDuplicated = false;
                for (String existingName : names){
                    if (existingName != null && existingName.equals(name)){
                        isDuplicated = true;
                        break;
                    }
                }
                if (!isDuplicated){
                    int key = name.hashCode();
                    put(key,name);

                }


                            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void startTheGame(){
        Scanner sc = new Scanner(System.in);
        int userChoice = -1;
        while (userChoice != 0) {
            System.out.println("Welcome to the edit menu:" + NEWLINE +
                    "1. Create a Hash-Table" + NEWLINE +
                    "2. Add an Entry" + NEWLINE +
                    "3. Remove an entry" + NEWLINE +
                    "4. Find an Entry" + NEWLINE +
                    "5. Display size" + NEWLINE +
                    "6. Add the CSV File" + NEWLINE +
                    "7. Display all elements" +NEWLINE +
                    "8. Check if name is in the Hash-Table"+NEWLINE+ NEWLINE + Color.RED_BOLD +
                    "0. Quit Edit Menu" + Color.RESET);

            try {


                userChoice = sc.nextInt();
                switch (userChoice) {

                    case 0 -> System.out.println("Existing");

                    case 1 -> {
                        System.out.println("Creating a Hash-Table.... " + NEWLINE + "Please Enter the size: ");
                        MyHashTable newHashTable = new MyHashTable(sc.nextInt());
                    }
                    case 2 -> {
                        System.out.println("Enter the key and value you want to add: ");
                        System.out.println("Key: ");
                        int userKey = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Value: ");
                        String userValue = sc.nextLine();
                        put(userKey, userValue);
                    }
                    case 3 -> {
                        System.out.println("Which value you want to delete?" + NEWLINE +
                                "Please Enter the key: ");
                        remove(sc.nextInt());
                    }
                    case 4 -> {
                        System.out.println("Do you want to search by Key");
                            System.out.println( find(sc.nextInt()));

                    }
                    case 5 -> System.out.println(Color.BLUE+"Size: " + getSize() + Color.RESET);

                    case 6 -> {
                        System.out.println("Adding the CSV file........" );
                        String filePath = "C:\\Users\\Ace\\IdeaProjects\\ADS2\\src\\main\\java\\hashtable\\names.csv";
                        String delimiter = ",";
                        addCSV(filePath, delimiter);
                    }
                    case 7 -> displayTable();
                    case 8 ->{
                        System.out.println("Enter The name: ");
                     String nameToLookFor = sc.next();

                        System.out.println( findValueInList(nameToLookFor));

                    }
                }

            } catch (InputMismatchException ime) {
                System.out.println("Wrong input. Try again!");
                sc.nextLine();
            }
        }

    }
}
