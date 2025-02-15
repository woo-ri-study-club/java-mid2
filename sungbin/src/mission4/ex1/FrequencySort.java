package mission4.ex1;

import java.util.*;

public class FrequencySort {
    public static int[] sortByFrequency(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> freqMap.get(a).equals(freqMap.get(b)) ? a - b : freqMap.get(b) - freqMap.get(a)
        );

        pq.addAll(freqMap.keySet());

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int num = pq.poll();
            for (int i = 0; i < freqMap.get(num); i++) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(Arrays.toString(sortByFrequency(nums)));
    }
}
