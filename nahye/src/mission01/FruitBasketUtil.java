package mission01;

import java.util.List;

public class FruitBasketUtil {

    public static <T extends Fruit> double calculateAveragePrice(List<T> fruits) {
        if (fruits.isEmpty()) return 0;

        double sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getPrice();
        }

        return sum / fruits.size();
    }

}
