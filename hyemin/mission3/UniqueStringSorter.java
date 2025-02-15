package mission3;

import java.util.*;

public class UniqueStringSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            hashSet.add(str);
            treeSet.add(str);
        }

        //TreeSet -> 코드가 더 간결함.
        System.out.println("treeSet 결과 = " + treeSet);

        //HashSet -> 메모리 효율과 성능이 더 좋음.
        List<String> result = getSortedUniqueStrings(hashSet);
        System.out.println("hashSet 결과 = " + result);
    }

    private static List<String> getSortedUniqueStrings(Set<String> set) {
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}
