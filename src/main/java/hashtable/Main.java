package hashtable;

public class Main {
    public static void main(String[] args) {
        MyHashTable my = new MyHashTable(20);
        System.out.println(my.getPrimeSize());

        FileSaver fs = new FileSaver();
        System.out.println(fs);
    }

}
