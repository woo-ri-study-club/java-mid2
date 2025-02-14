package jaehoon.section10.problem01;

import java.util.*;

public class FrequencySort {

  public static void main(String[] args) {
    int[] nums1 = {4, 1, 1, 2, 2, 2, 3, 3};
    System.out.println("result1 = " + Arrays.toString(solution(nums1)));
    // 출력예시: 2, 2, 2, 1, 1, 3, 3, 4
  }

  private static int[] solution(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // 등장빈도에 따라 내림차순, 빈도가 같다면 숫자가 작은 것이 앞에 오도록 정렬
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        Comparator.comparing(Map.Entry<Integer, Integer>::getValue, Comparator.reverseOrder())
                  .thenComparing(Map.Entry::getKey)
    );
    // 우선순위 큐에 넣음
    pq.addAll(map.entrySet());

    // 우선순위 큐에서 꺼내면서 결과 저장
    int[] result = new int[nums.length];
    int index = 0;
    while (!pq.isEmpty()) {
      Map.Entry<Integer, Integer> entry = pq.poll();
      int number = entry.getKey();
      int frequency = entry.getValue();

      for (int i = 0; i < frequency; i++) {
        result[index++] = number;
      }
    }

    return result;
  }
}
