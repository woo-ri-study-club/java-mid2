package mission2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("전체 인원 수(n)를 입력하십시오: ");
        int n = scanner.nextInt();

        System.out.print("제거 간격(k)를 입력하십시오: ");
        int k = scanner.nextInt();

        System.out.print("ArrayList를 사용하려면 1, LinkedList를 사용하려면 2를 입력하십시오: ");
        int choice = scanner.nextInt();

        List<Integer> list;

        switch (choice) {
            case 1 -> list = new ArrayList<>();
            case 2 -> list = new LinkedList<>();
            default -> throw new IllegalArgumentException("잘못된 선택지를 입력하셨습니다.");
        }

        JosephusSolver solver = new JosephusSolver(list, k);
        solver.initialize(n);

        long startTime = System.currentTimeMillis();

        int result = solver.solve();

        long endTime = System.currentTimeMillis();

        System.out.println("마지막에 남은 사람의 번호: " + result);
        System.out.println("측정 시간: " + (endTime - startTime) + "ms");
        scanner.close();
    }
}
