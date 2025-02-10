package jaehoon.section03.problem02;

import jaehoon.section03.problem01.Book;
import jaehoon.section03.problem01.Device;
import jaehoon.section03.problem01.Goods;
import jaehoon.section03.problem01.Item;

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

    System.out.println("First(): " + orderPair.getFirst());
    System.out.println("Second():");
    printItems(orderPair.getSecond());
  }

  private static void printItems(List<Item> items) {
    for (Item item : items) {
      System.out.println("item = " + item);
    }
  }
}
