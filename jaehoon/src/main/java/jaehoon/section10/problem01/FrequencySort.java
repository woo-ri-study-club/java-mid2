package jaehoon.section10.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

  // 입력예시:
  // 4, 1, 1, 2, 2, 2, 3, 3
  //
  // 출력예시:
  // 2, 2, 2, 1, 1, 3, 3, 4
  //
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int[] nums = Arrays.stream(br.readLine().split(", "))
                         .mapToInt(Integer::parseInt)
                         .toArray();

      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }

      // 등장빈도에 따라 내림차순, 빈도가 같다면 숫자가 작은 것이 앞에 오도록 정렬
      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
          (e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())) {
              return Integer.compare(e2.getValue(), e1.getValue());
            }
            return Integer.compare(e1.getKey(), e2.getKey());
          }
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

      // 출력
      System.out.println("result = " + Arrays.toString(result));

    } catch (Exception exception) {
      System.out.println("exception.getMessage() = " + exception.getMessage());
    }
  }
}
