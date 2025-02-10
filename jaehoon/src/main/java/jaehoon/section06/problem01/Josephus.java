package jaehoon.section06.problem01;

import java.util.List;
import java.util.ListIterator;

public class Josephus {

  private final List<Integer> people;

  public Josephus(int peopleCount, List<Integer> people) {
    validatePeopleCount(peopleCount);
    this.people = people;
    for (int i = 1; i <= peopleCount; i++) {
      people.add(i);
    }
  }

  private void validatePeopleCount(int peopleCount) {
    if (peopleCount <= 0) {
      throw new IllegalArgumentException("사람이 존재하지 않습니다.");
    }
  }

  private void validateRemovalInterval(int interval) {
    if (interval < 0) {
      throw new IllegalArgumentException("제거 간격은 음수가 들어올 수 없습니다.");
    }
  }

  public long getPeopleSize() {
    return people.size();
  }

  public int lastRemainPerson(int K) {
    validateRemovalInterval(K);
    if (K == 0) {
      return people.getLast();
    }

    int currentIndex = 0;
    while (people.size() > 1) {
      currentIndex = (currentIndex + K - 1) % people.size();
      people.remove(currentIndex);
    }
    return people.getFirst();
  }

  public int lastRemainPersonIter(int K) {
    validateRemovalInterval(K);
    if (K == 0) {
      return people.getLast();
    }

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

    return people.getFirst();
  }
}
