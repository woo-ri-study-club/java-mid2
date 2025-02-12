package mission04;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Quiz_1_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("배열의 길이를 입력하세요:");
        int[] nums = new int[sc.nextInt()];

        System.out.print("배열에 들어갈 값을 입력하세요.");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        Map<Integer, Integer> frequencyTable = countFrequencies(nums);

        PriorityQueue<Map.Entry<Integer, Integer>> integers = sortByFrequency(frequencyTable);

        printSortedByFrequency(integers);

        sc.close();
    }

    public static Map<Integer, Integer> countFrequencies(int[] nums) {
        Map<Integer, Integer> tableForDuplicate = new HashMap<>();

        for (int num : nums) {
            tableForDuplicate.put(num, tableForDuplicate.getOrDefault(num, 0) + 1);
        }
        return tableForDuplicate;
    }

    private static PriorityQueue<Map.Entry<Integer, Integer>> sortByFrequency(Map<Integer, Integer> frequencyTable) {

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.getValue().equals(b.getValue())) {
                        return a.getKey() - b.getKey();
                    }
                    return b.getValue() - a.getValue();
                }
        );

        maxHeap.addAll(frequencyTable.entrySet());
        return maxHeap;
    }

    private static void printSortedByFrequency(PriorityQueue<Map.Entry<Integer, Integer>> maxHeap) {

        StringBuilder stringBuilder = new StringBuilder();

        while (maxHeap.size() > 0) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            int number = entry.getKey();
            int frequency = entry.getValue();

            for (int i = 0; i < frequency; i++) {
                stringBuilder.append(number).append(" ");
            }
        }
        System.out.println(stringBuilder);
    }
}