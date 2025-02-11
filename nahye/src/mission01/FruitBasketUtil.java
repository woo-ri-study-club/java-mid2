package mission01;

import java.util.Comparator;
import java.util.List;

public class FruitBasketUtil {

    public static <T extends Fruit> double calculateAveragePrice(List<T> fruits) {
        if (fruits == null || fruits.isEmpty()) return 0;

        double sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getPrice();
        }

        return sum / fruits.size();
    }


    public static final Comparator<Fruit> priceComparator = new Comparator<Fruit>() {
        @Override
        public int compare(Fruit f1, Fruit f2) {
            return Integer.compare(f1.getPrice(), f2.getPrice());
        }
    };





}
