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

        int[] nums_2 = {7, 7, 7, 1, 8, 8, 9};
        int[] answer_2 = {7, 7, 7, 8, 8, 1, 9};
        System.out.println("frequencySort(nums_2) = " + Arrays.toString(frequencySort(nums_2)));

    }

    private static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (a, b) -> b.getValue() != a.getValue() ? Integer.compare(b.getValue(), a.getValue())
                        : Integer.compare(a.getKey(), b.getKey()));

//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            queue.add(entry);
//        }
        queue.addAll(map.entrySet());
        List<Integer> list = new ArrayList<>();

        //PriorityQueue는 힙 구조로 정렬하는데 힙은 전체 정렬이 아닌 최솟값(또는 최대값이 루트에 있도록 정렬된 트리 구조라서
        //for-each로 순회하면 정렬된 값이 나오지 않는다 .poll()사용하기
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entryMap = queue.poll();
            for (int i = 0; i < entryMap.getValue(); i++) {
                list.add(entryMap.getKey());
            }
        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
