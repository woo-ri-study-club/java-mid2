package mission4;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesisChecker {
    public static void main(String[] args) {
        System.out.println(isValid("{[()]}")); // "YES"
        System.out.println(isValid("{[(])}")); // "NO"
        System.out.println(isValid("{{[[(())]]}}")); // "YES"
    }
    
    public static String isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static boolean isMatchingPair(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '{' && right == '}') ||
                (left == '[' && right == ']');
    }
}

