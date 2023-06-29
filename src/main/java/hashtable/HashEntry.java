package hashtable;

public class HashEntry {
    private String value;
    private int key;
    private boolean deleted;

    public String getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void delete(){
        deleted = true;
    }
    public HashEntry(String value, int key){
        this.key = key;
        this.value = value;
        deleted = false;

    }
}
