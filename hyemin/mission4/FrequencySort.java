package mission4;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 1, 2, 2, 2, 3, 3};
        int[] result1 = frequencySort(nums1);
        System.out.println(Arrays.toString(result1)); // [2, 2, 2, 1, 1, 3, 3, 4]

        int[] nums2 = {7, 7, 7, 8, 8, 9};
        int[] result2 = frequencySort(nums2);
        System.out.println(Arrays.toString(result2)); // [7, 7, 7, 8, 8, 9]
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 방법 1
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if(Objects.equals(a.getValue(), b.getValue())){
                        return Integer.compare(a.getKey(), b.getKey());
                    }
                    return Integer.compare(b.getValue(), a.getValue());
                }
        );

        // 방법 2
//        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
//                Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed()
//                        .thenComparing(Map.Entry.comparingByKey())
//        );


        maxHeap.addAll(frequencyMap.entrySet());

        List<Integer> sortedList = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                sortedList.add(num);
            }
        }

        return sortedList.stream().mapToInt(Integer::intValue).toArray();
    }
}
