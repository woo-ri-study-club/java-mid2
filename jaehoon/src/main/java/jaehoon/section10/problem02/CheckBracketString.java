package jaehoon.section10.problem02;

import java.util.ArrayDeque;
import java.util.Map;

public class CheckBracketString {

  private final static Map<Character, Character> BRACKET_MAP = Map.of('(', ')',
                                                                      '{', '}',
                                                                      '[', ']');

  public static void main(String[] args) {
    String s1 = "{[()]}";
    System.out.println("result1 = " + solution(s1)); // YES

    String s2 = "{[(])}";
    System.out.println("result2 = " + solution(s2)); // NO

    String s3 = "{{[[(())]]}}";
    System.out.println("result3 = " + solution(s3)); // YES
  }

  public static String solution(String str) {

    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (char ch : str.toCharArray()) {
      if (BRACKET_MAP.containsKey(ch)) {
        stack.push(ch);
      } else {
        if (stack.isEmpty() || ch != BRACKET_MAP.get(stack.pop())) {
          return "NO";
        }
      }
    }

    return stack.isEmpty() ? "YES" : "NO";
  }
}
