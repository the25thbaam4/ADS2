package hashtable;

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
        for (int i = TABLE_SIZE -1; i >= 1 ; i-- ){
          int primeCounter = 0;
          for (int j = 2; j * j <= i; j++)
              if (i % j == 0) primeCounter++;
              if (primeCounter == 0) return i;

        }
        return 3;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void makeEmpty(){
        size = 0;
        for (int i = 0; i < TABLE_SIZE; i++){
            table[i] = null;
        }
    }


    public MyHashTable(int capacity){
        size = 0;
        TABLE_SIZE = capacity;
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
            primeSize = getPrimeSize();

    }









    @Override
    public void put(Integer key, String value) {
        if (key == null)
            throw  new IllegalArgumentException("Key can not be Null");
        if (size == TABLE_SIZE){
            System.out.println("Table is full");
            return;
        }



    }

    @Override
    public void remove(Integer key) {

    }

    @Override
    public String find(Integer key) {
        return null;
    }
}
