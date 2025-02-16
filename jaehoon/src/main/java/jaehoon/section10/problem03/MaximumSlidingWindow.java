package jaehoon.section10.problem03;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximumSlidingWindow {

  public static void main(String[] args) {
    int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
    int k1 = 3;
    System.out.println(Arrays.toString(solution(nums1, k1)));

    int[] nums2 = {9, 11, 8, 5, 7, 10};
    int k2 = 2;
    System.out.println(Arrays.toString(solution(nums2, k2)));
  }

  // Deque활용 풀이 - O(N)
  public static int[] solution(int[] nums, int k) {
    // 결과를 저장할 배열
    int[] result = new int[nums.length - k + 1];
    int index = 0;
    ArrayDeque<Integer> deque = new ArrayDeque<>();

    // 배열을 한 번 순회하면서 슬라이딩 윈도우 처리
    for (int i = 0; i < nums.length; i++) {
      // 1. 윈도우 범위 벗어난 인덱스 제거
      if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }

      // 2. 현재 값보다 작은 값은 필요 없으므로 제거 (내림차순 유지)
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }

      // 3. 현재 인덱스 추가
      deque.offerLast(i);

      // 4. 슬라이딩 윈도우가 완성되면 결과 배열에 최대값 추가
      if (i >= k - 1) {
        result[index++] = nums[deque.peekFirst()];
      }
    }

    return result;
  }

  // 시간초과 풀이 - O(N * K)
  public static int[] invalidSolution(int[] nums, int k) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < k; i++) {
      if (nums[i] >= max) {
        max = nums[i];
      }
    }
    int[] result = new int[nums.length - k + 1];
    result[0] = max;

    int lIdx = 0;
    int rIdx = k - 1;
    int count = 1;
    while (rIdx < nums.length - 1) {
      lIdx++;
      rIdx++;
      for (int i = lIdx; i <= rIdx; i++) {
        if (nums[i] >= max) {
          max = nums[i];
        }
      }
      result[count++] = max;
      max = Integer.MIN_VALUE;
    }
    return result;
  }
}
