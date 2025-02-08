package jaehoon.section06.problem01;

import java.util.List;
import java.util.ListIterator;

public class Josephus {

  private final List<Integer> people;

  public Josephus(List<Integer> people) {
    this.people = people;
  }

  public int lastRemainPerson(int K) {
    int currentIndex = 0;
    while (people.size() > 1) {
      currentIndex = (currentIndex + K - 1) % people.size();
          people.remove(currentIndex);
    }
    return people.get(0);
  }

  public int lastRemainPersonIter(int K) {
    ListIterator<Integer> iterator = people.listIterator();
    while (people.size() > 1) {
      for (int i = 0; i < K; i++) {
        // 순환을 처리하기 위해 iterator 초기화
        if (!iterator.hasNext()) {
          iterator = people.listIterator();
        }
        iterator.next();
      }
      iterator.remove();
    }
    return people.get(0);
  }
}
