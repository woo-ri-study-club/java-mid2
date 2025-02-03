package mission1;

public class Pair<K, V> {
    private final K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("age", 20);
        System.out.println("Key: " + pair.getKey());
        System.out.println("Value: " + pair.getValue()); //20
        pair.setValue(30);
        System.out.println("Value: " + pair.getValue()); //30
    }
}
