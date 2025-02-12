package collection.set.mission03;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("입력할 문자열 개수를 입력하세요.(1 ≤ n ≤ 100,000): ");
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> set = new HashSet<>();

        long startTime = System.nanoTime();

        System.out.println("문자열을 하나씩 입력하세요.");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextLine());
        }

        //스트림 변환[O(n)] -> sorted 정렬[O(nlogn)] -> toList[O(n)]
        // ⇒ 최종 시간 복잡도[O(nlogn)]
        List<String> list = set.stream().sorted().toList();
        list.forEach(s -> System.out.println(s));

        long endTime = System.nanoTime();
        System.out.println("소요 시간: " + (endTime - startTime));

        sc.close();
    }
}
