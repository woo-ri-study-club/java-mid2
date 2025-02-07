package jaehoon.section03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PairMain {

  public static void main(String[] args) {
    List<Item> items = new ArrayList<>();
    items.add(new Book("가상면접 사례로 배우는 대규모 설계 기초1",
                       20_000,
                       "알렉스 쉬"));

    items.add(new Device("아이폰16Pro",
                         1_000_000,
                         LocalDate.of(2027, 2, 7)));

    items.add(new Goods("공책", 3000));

    Pair<Order, List<Item>> orderPair = Pair.of(new Order(1), items);

    System.out.println("First() = " + orderPair.getFirst());
    System.out.println("Second() = " + orderPair.getSecond());
  }
}
