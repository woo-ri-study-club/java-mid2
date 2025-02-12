import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mission1 {
    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 1, 2, 2, 2, 3, 3}, new int[]{2, 2, 2, 1, 1, 3, 3, 4}),
                Arguments.of(new int[]{7, 7, 7, 8, 8, 9}, new int[]{7, 7, 7, 8, 8, 9})
        );
    }

    @DisplayName("빈도 기반 정렬")
    @ParameterizedTest
    @MethodSource("provideData")
    void frequencyBasedAlignment(int[] input, int[] expected) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : input) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a, b) -> hashMap.get(a).equals(hashMap.get(b)) ? a - b : hashMap.get(b) - hashMap.get(a)
        );

        priorityQueue.addAll(hashMap.keySet());

        int[] result = priorityQueue.stream()
                .flatMapToInt(i -> IntStream.generate(() -> i)
                        .limit(hashMap.get(i)))
                .toArray();

        Assertions.assertArrayEquals(expected, result);
    }

    @DisplayName("Stream을 이용한 빈도 기반 정렬")
    @ParameterizedTest
    @MethodSource("provideData")
    void frequencyBasedAlignmentWithStream(int[] input, int[] expected) {
        int[] result = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int freqCompare = Long.compare(b.getValue(), a.getValue()); // 빈도수 내림차순
                    return (freqCompare != 0) ? freqCompare : Integer.compare(a.getKey(), b.getKey()); // 빈도가 같으면 숫자 오름차순
                })
                .flatMap(e -> Collections.nCopies(e.getValue().intValue(), e.getKey()).stream())
                .mapToInt(i -> i)  // Integer -> int 변환
                .toArray();

        Assertions.assertArrayEquals(expected, result);
    }
}
