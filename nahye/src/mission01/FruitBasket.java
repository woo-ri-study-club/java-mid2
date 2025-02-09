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

    public void showFruits() {
        System.out.println("Fruit Basket contains: " + fruits);
    }

}
