package collection.mission02;

import java.util.List;

public class Josephus {
    private final List<Integer> list;
    private final int gap;

    public Josephus(List<Integer> list, int gap) {
        this.list = list;
        this.gap = gap;
    }

    public void initialize(int total) {
        for (int i = 1; i <= total; i++) {
            list.add(i);
        }
    }

    public int josephus() {
        int current = 0;

        while (list.size() > 1) {
            current = (current + gap - 1) % list.size();
            list.remove(current);
        }

        return list.get(0);
    }
}


