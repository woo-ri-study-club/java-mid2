package mission1;

import mission1.fruits.Fruit;

public class FruitBoxInfo {

    static  <T extends Fruit> void checkRipeness(FruitBox<T> b ) {
        for (T fruit : b.getFruits()) {
            System.out.println(fruit.isRipe() ? "익었습니다!" : "아직 익지 않았습니다!");
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
