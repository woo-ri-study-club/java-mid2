package mission1;

import mission1.fruits.Fruit;

public class FruitBoxInfo {

    static  <T extends Fruit> void checkRipeness(FruitBox<T> b ) {
        T t = b.get();
        System.out.println(t.isRipe() ? "익었습니다!" : "아직 익지 않았습니다!");
    }

    static <T extends Fruit> void printWithGeneric(FruitBox<T> b) {
        T t = b.get();
        t.showInfo();
    }

    static void printWithWildcard(FruitBox<? extends Fruit> b) {
        Fruit fruit = b.get();//와일드카드는 바로 상한 타입
        fruit.showInfo();
    }
}
