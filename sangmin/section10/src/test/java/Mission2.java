import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Stream;

public class Mission2 {
    static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("{[()]}", "YES"),
                Arguments.of("{[(])}", "NO"),
                Arguments.of("{{[[(())]]}}", "YES")
        );
    }

    @DisplayName("빈도 기반 정렬")
    @ParameterizedTest
    @MethodSource("provideData")
    void parentheses(String input, String expected) {
        String result = "YES";

        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            stack.add(c);
        }

        while (!stack.isEmpty()) {
            char c = stack.pollFirst();
            if (c == '{') {
                if (stack.peekLast() == '}') {
                    stack.pollLast();
                } else {
                    result = "NO";
                    break;
                }
            } else if (c == '[') {
                if (stack.peekLast() == ']') {
                    stack.pollLast();
                } else {
                    result = "NO";
                    break;
                }
            } else if (c == '(') {
                if (stack.peekLast() == ')') {
                    stack.pollLast();
                } else {
                    result = "NO";
                    break;
                }
            }
        }

        Assertions.assertEquals(expected, result);
    }
}
