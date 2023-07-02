package hashtable;

public class HashEntry <K, V>{
    private V value;
    private K key;
    private boolean deleted;


    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }


    public HashEntry(K key, V value){
        this.key = key;
        this.value = value;
        this.deleted = false;

    }
}
