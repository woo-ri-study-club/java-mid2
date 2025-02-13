package collection.map.mission04;

import java.util.*;

public class PrioritySort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 2, 2, 2, 3, 3};

        Map<Integer, Integer> priorityMap = new HashMap<>();

        for (int i : nums) {
            priorityMap.put(i, priorityMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((k1, k2) -> {
            if (priorityMap.get(k1).equals(priorityMap.get(k2))) {
                return Integer.compare(k1, k2);
            }

            return Integer.compare(priorityMap.get(k2), priorityMap.get(k1));
        });

        priorityQueue.addAll(priorityMap.keySet());

        List<Integer> result = new ArrayList<>();

        priorityQueue.forEach(integer -> {
                    int freq = priorityMap.get(integer);

                    for (int i = 0; i < freq; i++) {
                        result.add(integer);
                    }
                }
        );

        System.out.println(Arrays.toString(result.toArray()));
    }
}
