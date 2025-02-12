import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

public class Mission3 {
    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                Arguments.of(new int[]{9, 11, 8, 5, 7, 10}, 2, new int[]{11, 11, 8, 7, 10})
        );
    }

    @DisplayName("슬라이딩 윈도우 최대값")
    @ParameterizedTest
    @MethodSource("provideData")
    void slidingWindowsMaximumValue(int[] nums, int k, int[] expected) {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        Assertions.assertArrayEquals(expected, result);
    }
}
