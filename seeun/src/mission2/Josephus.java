package mission2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Josephus {

    public static void main(String[] args) {

        long start = System.nanoTime();
        josephusWithArrayList(100000, 3);
        long end = System.nanoTime();
        System.out.println("ArrayList를 활용한 실행시간: " + (end - start));

        start = System.nanoTime();
        josephusWithLinkedList(100000, 3);
        end = System.nanoTime();
        System.out.println("LinkedList를 활용한 실행시간: " + (end - start));

    }

    public static void josephusWithArrayList(int n, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        while (!list.isEmpty()) {
            index = (index + (k - 1)) % list.size();

            if (list.size() == 1) {
                System.out.println(list.remove(index));
                return;
            }
            list.remove(index);
        }
    }

    public static void josephusWithLinkedList(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        while (!list.isEmpty()) {
            index = (index + (k - 1)) % list.size();

            if (list.size() == 1) {
                System.out.println(list.remove(index));
                return;
            }
            list.remove(index);
        }

    }
}
