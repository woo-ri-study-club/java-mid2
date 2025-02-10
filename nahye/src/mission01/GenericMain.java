package mission01;

import java.util.Collections;
import java.util.Comparator;

public class GenericMain {
    public static void main(String[] args) {
        // 사과 바구니
        FruitBasket<Apple> appleBasket = new FruitBasket<>();
        appleBasket.addFruit(new Apple("Korea", 3000));
        appleBasket.addFruit(new Apple("USA", 2500));

        // 바나나 바구니
        FruitBasket<Banana> bananaBasket = new FruitBasket<>();
        bananaBasket.addFruit(new Banana("Philippines", 1500));
        bananaBasket.addFruit(new Banana("Ecuador", 2000));

        // 모든 과일을 담은 바구니
        FruitBasket<Fruit> fruitBasket = new FruitBasket<>();
        fruitBasket.addFruit(new Apple("Korea", 3000));
        fruitBasket.addFruit(new Apple("USA", 2500));
        fruitBasket.addFruit(new Banana("Philippines", 1500));
        fruitBasket.addFruit(new Banana("Ecuador", 2000));

        // 바구니 출력
        System.out.println(appleBasket);
        System.out.println(bananaBasket);
        System.out.println(fruitBasket);

        double avgPriceAllApple = FruitBasketUtil.calculateAveragePrice(appleBasket.getFruits());
        System.out.println("사과 바구니의 평균 가격 : " + avgPriceAllApple);

        double avgPriceAllBanana = FruitBasketUtil.calculateAveragePrice(bananaBasket.getFruits());
        System.out.println("바나나 바구니의 평균 가격 : " + avgPriceAllBanana);

        double avgPriceAllFruit = FruitBasketUtil.calculateAveragePrice(fruitBasket.getFruits());
        System.out.println("과일 바구니의 평균 가격 : " + avgPriceAllFruit);


        Collections.sort(fruitBasket.getFruits(), FruitBasketUtil.priceComparator);
        System.out.println("가격 오름차순 정렬 : " + fruitBasket.getFruits());
    }
}
