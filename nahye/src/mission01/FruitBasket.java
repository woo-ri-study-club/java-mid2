package mission01;

import java.util.ArrayList;
import java.util.List;

public class FruitBasket<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public List<T> getFruits() {
        return fruits;
    }

    @Override
    public String toString() {
        return "과일 바구니에 담겨있는 것 : " + fruits;
    }
}
