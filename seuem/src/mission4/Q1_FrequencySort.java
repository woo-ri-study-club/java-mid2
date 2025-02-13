import java.util.*;


public class Q1_FrequencySort {
    public static void main(String[] args) {
        /**
         * 빈도수에 따라 내림차 순 정렬
         * 빈도수가 같을 시 작은 숫자 먼저 정렬
         *
         * hashmap으로 빈도 저장
         * PriorityQueue(최소 힙) 또는 TreeMap로 정렬
         */
        int[] nums = {4, 1, 1, 2, 2, 2, 3, 3};
        int[] answer = {2, 2, 2, 1, 1, 3, 3, 4};

        //성빈님 코드에서 메서드 이름 뺏김!! *-*v
        System.out.println("frequencySort(nums) = " + Arrays.equals(answer, frequencySort(nums)));
    }

    private static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[1] != b[1] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0])
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        List<Integer> list = new ArrayList<>();
        for (int[] ints : queue) {
            for (int i = 0; i < ints[1]; i++) {
                list.add(ints[0]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
