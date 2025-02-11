package mission04;

import java.util.*;

public class Quiz01Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("배열의 길이를 입력하세요:");
        int[] nums = new int[sc.nextInt()];

        System.out.print("배열에 들어갈 값을 입력하세요.");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        Map<Integer, Integer> frequencyTable = countFrequencies(nums);

        TreeMap<Integer, List<Integer>> sortedByFrequency = sortByFrequency(frequencyTable);

        printSortedByFrequency(sortedByFrequency);

    }

    public static Map<Integer, Integer> countFrequencies(int[] nums) {
        Map<Integer, Integer> tableForDuplicate = new HashMap<>();

        for (int num : nums) {
            tableForDuplicate.put(num, tableForDuplicate.getOrDefault(num, 0) + 1);
        }
        return tableForDuplicate;
    }

    private static TreeMap<Integer, List<Integer>> sortByFrequency(Map<Integer, Integer> frequencyTable) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) {
            treeMap.computeIfAbsent(entry.getValue(),
                    k -> new ArrayList<>()).add(entry.getKey());
        }
        return treeMap;
    }

    private static void printSortedByFrequency(TreeMap<Integer, List<Integer>> treeMap) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            for (int num : entry.getValue()) {
                for (int i = 0; i < entry.getKey(); i++) {
                    result.add("" + num);
                }
            }
        }

        System.out.println(result);
    }
}
