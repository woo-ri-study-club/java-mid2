package mission1;

import mission1.fruits.Fruit;

public class FruitBox<T extends Fruit> {

    private T fruit;

    public void store(T fruit) {
        this.fruit = fruit;
    }

    public T get() {
        return fruit;
    }
}
