package mission1;

import mission1.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit> {

    private List<T> fruits;

    public FruitBox() {
        this.fruits = new ArrayList<>();
    }

    public void store(T fruit) {
        fruits.add(fruit);
    }

    public List<T> getFruits() {
        return new ArrayList<>(fruits);
    }
}
