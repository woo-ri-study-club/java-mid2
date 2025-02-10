package mission3;

import java.util.*;

public class UniqueStringSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            set.add(str);
        }

        List<String> result = removeDuplicatesAndSort(set);
        System.out.println("결과 = " + result.toString());
    }

    private static List<String> removeDuplicatesAndSort(Set<String> set) {
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}
