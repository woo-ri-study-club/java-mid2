package collection.map.mission04;

import java.util.*;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;

        Deque<Integer> window = new ArrayDeque<>();
        List<Integer> maxNums = new ArrayList<>();

        slidingWindowUsingByIndex(nums, window, windowSize, maxNums);

        System.out.println(maxNums);
    }

    //개선 로직
    private static void slidingWindowUsingByIndex(int[] nums, Deque<Integer> window, int windowSize, List<Integer> maxNums) {
        for (int i = 0; i < nums.length; i++) {
            //windowSize를 초과 시 제거
            if (!window.isEmpty() && window.peekFirst() <= i - windowSize) {
                window.pollFirst();
            }

            //offer한 인덱스를 이전 인덱스들의 값 크기 비교 후 작으면 제거
            while (!window.isEmpty() && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }

            //인덱스 offer
            window.offerLast(i);

            if (i + 1 >= windowSize) {
                maxNums.add(nums[window.peekFirst()]);
            }

        }
    }

    //초기 로직
    private static void slidingWindowUsingByFixedSize(int[] nums, Deque<Integer> window, List<Integer> maxNums) {
        for (int i : nums) {
            window.offer(i);

            if (window.size() > 2) {
                window.poll();
            }

            if (window.size() == 2) {
                maxNums.add(
                        window.stream().mapToInt(n -> n).max().getAsInt()
                );
            }
        }
    }
}