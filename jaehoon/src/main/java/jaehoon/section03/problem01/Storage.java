package jaehoon.section03.problem01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Storage<T extends Item> {

  private final List<T> items = new ArrayList<>();

  public void addItem(T item) {
    items.add(item);
  }

  public void addItems(Collection<? extends T> e) {
    items.addAll(e);
  }

  public T getItem(int index) {
    return items.get(index);
  }

  public List<T> getItems() {
    return items;
  }

  public boolean isEmpty() {
    if (items.isEmpty()) {
      return true;
    }
    return false;
  }

  // 아이템을 다른 Storage로 옮기기 (하한 와일드카드)
  public synchronized void transferItems(Storage<? super T> destination) {
    destination.addItems(items);
    items.clear(); // 기존 창고 비우기
  }
}
