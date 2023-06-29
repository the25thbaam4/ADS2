package hashtable;

public interface BasicMethods <K, V> {
    void put(K key, V value);
    void remove(K key);
    V find(K key);

}
