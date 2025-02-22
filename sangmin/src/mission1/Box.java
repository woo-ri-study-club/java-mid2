package mission1;

public class Box <T extends Comparable<T>> {

    private final T value;

    public Box(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int compareTo(Box<T> other) {
        return value.compareTo(other.getValue());
    }


    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>(10);
        Box<Integer> box2 = new Box<>(20);
        System.out.println(box1.compareTo(box2)); // -1

        Box<String> box3 = new Box<>("Hello");
        Box<String> box4 = new Box<>("World");
        System.out.println(box3.compareTo(box4)); // -15
    }
}
