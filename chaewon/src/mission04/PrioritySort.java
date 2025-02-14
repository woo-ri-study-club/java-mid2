package collection.map.mission04;

import java.util.*;

public class PrioritySort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 2, 2, 2, 3, 3};

        Map<Integer, Integer> priorityMap = new HashMap<>();

        for (int num : nums) {
            priorityMap.put(num, priorityMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue()).reversed()
        );

        priorityQueue.addAll(priorityMap.entrySet());

        List<Integer> result = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> pollEntry = priorityQueue.poll();
            int num = pollEntry.getKey();
            int freq = pollEntry.getValue();

            for (int i = 0; i < freq; i++) {
                result.add(num);
            }
        }

        System.out.println(result);
    }
}