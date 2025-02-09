package mission1;

import mission1.fruits.Apple;
import mission1.fruits.Banana;

public class FruitBoxMain {

    public static void main(String[] args) {

        FruitBox<Apple> fruitBox1 = new FruitBox<>();
        fruitBox1.store(new Apple(10000, "red", 5));

        FruitBox<Banana> fruitBox2 = new FruitBox<>();
        fruitBox2.store(new Banana(15000, "black", 2));

        FruitBoxInfo.checkRipeness(fruitBox1);
        FruitBoxInfo.checkRipeness(fruitBox2);

        FruitBoxInfo.printWithGeneric(fruitBox1);
        FruitBoxInfo.printWithGeneric(fruitBox2);

        FruitBoxInfo.printWithWildcard(fruitBox1);
        FruitBoxInfo.printWithWildcard(fruitBox2);
    }
}
