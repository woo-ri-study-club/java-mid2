package jaehoon.section03;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends Item> {

  private List<T> items = new ArrayList<>();

  public void addItem(T item) {
    items.add(item);
  }

  public T getItem(int index) {
    return items.get(index);
  }

  // 와일드카드를 활용한 아이템 목록 출력
  public static void printItems(Storage<? extends Item> storage) {
    for (Item item : storage.items) {
      System.out.println(item);
    }
  }

  // 아이템을 다른 Storage로 옮기기 (하한 와일드카드)
  public void transferItems(Storage<? super T> destination) {
    for (T item : items) {
      destination.addItem(item);
    }
    items.clear(); // 기존 창고 비우기
  }
}
