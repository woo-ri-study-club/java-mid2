package jaehoon.section10.problem02;

import java.util.ArrayDeque;
import java.util.Map;

public class CheckParenthesisString {

  public static void main(String[] args) {
    String s1 = "{[()]}";
    System.out.println("result1 = " + solution(s1)); // YES

    String s2 = "{[(])}";
    System.out.println("result2 = " + solution(s2)); // NO

    String s3 = "{{[[(())]]}}";
    System.out.println("result3 = " + solution(s3)); // YES
  }

  public static String solution(String str) {
    Map<Character, Character> map = Map.of('(', ')',
                                           '{', '}',
                                           '[', ']');

    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (char ch : str.toCharArray()) {
      if (map.containsKey(ch)) {
        stack.push(ch);
      } else {
        if (stack.isEmpty() || ch != map.get(stack.pop())) {
          return "NO";
        }
      }
    }

    return stack.isEmpty() ? "YES" : "NO";
  }
}
