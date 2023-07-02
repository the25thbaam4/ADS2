package hashtable;

public interface CRDMethods<K, V> {
    void put(K key, V value);
    void remove(K key);
    V find(K key);
    void displayTable();
}
