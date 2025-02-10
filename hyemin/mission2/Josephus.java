package mission2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n (총 인원): ");
        int n = scanner.nextInt();

        System.out.print("k (제거 간격): ");
        int k = scanner.nextInt();

        List<Integer> arrayList = initPeople(n, new ArrayList<>());
        List<Integer> linkedList = initPeople(n, new LinkedList<>());

        // arrayList
        long startTime = System.nanoTime();
        int arrayListResult = josephus(n, arrayList, k);
        long endTime = System.nanoTime();
        System.out.println("arrayListResult (남은 사람의 번호) = " + arrayListResult);
        System.out.println("소요 시간: " + (endTime - startTime) + " 나노초"); // n = 100000, k = 3일때 소요시간 259134375 나노초

        // linkedList
        startTime = System.nanoTime();
        int linkedListResult = josephus(n, linkedList, k);
        endTime = System.nanoTime();
        System.out.println("linkedListResult (남은 사람의 번호) = " + linkedListResult);
        System.out.println("소요 시간: " + (endTime - startTime) + " 나노초"); // n = 100000, k = 3일때 소요시간 2247374667 나노초 (arrayList보다 약 10배 느림)
    }

    private static Integer josephus(int n, List<Integer> people, int k) {
        int index = 0;
        while (people.size() > 1) {
            index = (index + k - 1) % people.size(); // k번째 사람 제거
            people.remove(index);
        }

        return people.getFirst();
    }

    private static List<Integer> initPeople(int n, List<Integer> people) {
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        return people;
    }
}

