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

        PriorityQueue<Integer> integers = sortByFrequency(frequencyTable);

        printSortedByFrequency(frequencyTable, integers);

        sc.close();
    }

    public static Map<Integer, Integer> countFrequencies(int[] nums) {
        Map<Integer, Integer> tableForDuplicate = new HashMap<>();

        for (int num : nums) {
            tableForDuplicate.put(num, tableForDuplicate.getOrDefault(num, 0) + 1);
        }
        return tableForDuplicate;
    }

    private static PriorityQueue<Integer> sortByFrequency(Map<Integer, Integer> frequencyTable) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if(frequencyTable.get(a).equals(frequencyTable.get(b)))
                        return a - b;
                    return frequencyTable.get(b) - frequencyTable.get(a);
                }
        );

        maxHeap.addAll(frequencyTable.keySet());
        return maxHeap;
    }

    private static void printSortedByFrequency(Map<Integer, Integer> frequencyTable, PriorityQueue<Integer> maxHeap) {

        StringBuilder stringBuilder = new StringBuilder();

        while (maxHeap.size() > 0) {
            int num = maxHeap.poll();
            for (int i = 0; i < frequencyTable.get(num) ; i++) {
                stringBuilder.append(num).append(" ");
            }
        }

        System.out.println(stringBuilder);
    }
}