package mission1;

import mission1.fruits.Fruit;

public class FruitBoxInfo {

    static  <T extends Fruit> void checkRipeness(FruitBox<T> b ) {
        for (T fruit : b.getFruits()) {
            System.out.print(fruit.getName() + "은(는) ");
            System.out.println(fruit.isRipe() ? "익었습니다!" : "익지 않았거나 상태가 좋지 않습니다..");
        }
    }

    static <T extends Fruit> void printWithGeneric(FruitBox<T> b) {
        for (T fruit : b.getFruits()) {
            fruit.showInfo();
        }
    }

    static void printWithWildcard(FruitBox<? extends Fruit> b) {
        for (Fruit fruit : b.getFruits()) {
            fruit.showInfo();
        }
    }
}
