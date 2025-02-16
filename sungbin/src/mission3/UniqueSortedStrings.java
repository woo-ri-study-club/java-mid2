package mission3;

import java.util.*;

public class UniqueSortedStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> set = new HashSet<>(); // 중복 제거만 수행
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextLine());
        }
        scanner.close();

        List<String> sortedList = new ArrayList<>(set);
        sortedList.sort(null);

        for (String s : sortedList) {
            System.out.println(s);
        }
    }
}
