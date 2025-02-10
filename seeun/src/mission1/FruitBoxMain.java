package mission1;

import mission1.fruits.Apple;
import mission1.fruits.Banana;

public class FruitBoxMain {

    public static void main(String[] args) {

        FruitBox<Apple> fruitBox1 = new FruitBox<>();
        fruitBox1.store(new Apple("맛있는 사과", 10000, "red", 5, 5));
        fruitBox1.store(new Apple("덜 맛있는 사과", 5000, "purple", 3, 10));

        FruitBox<Banana> fruitBox2 = new FruitBox<>();
        fruitBox2.store(new Banana("썩은 바나나", 15000, "black", 2, 7));
        fruitBox2.store(new Banana("맛있는 바나나", 8000, "yellow", 5, 10));
        fruitBox2.store(new Banana("덜 익은 바나나", 10000, "green", 1, 15));

        FruitBoxInfo.checkRipeness(fruitBox1);
        FruitBoxInfo.checkRipeness(fruitBox2);

        FruitBoxInfo.printWithGeneric(fruitBox1);
        FruitBoxInfo.printWithGeneric(fruitBox2);

        FruitBoxInfo.printWithWildcard(fruitBox1);
        FruitBoxInfo.printWithWildcard(fruitBox2);
    }
}
