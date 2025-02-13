package jaehoon.section10.problem02;

import java.util.ArrayDeque;
import java.util.Map;

public class CheckParenthesisString {

  // 입력예시:
  // {{[[(())]]}}
  //
  // 출력예시:
  // YES
  //
  public static void main(String[] args) {
    String s1 = "{[()]}";
    System.out.println("result1 = " + solution(s1));

    String s2 = "{[(])}";
    System.out.println("result2 = " + solution(s2));

    String s3 = "{{[[(())]]}}";
    System.out.println("result3 = " + solution(s3));
  }

  public static String solution(String str) {
    Map<Character, Character> map = Map.of('(', ')',
                                           '{', '}',
                                           '[', ']');

    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (map.containsKey(ch)) {
        stack.addLast(ch);
      } else {
        if (stack.isEmpty() || ch != map.get(stack.pollLast())) {
          return "NO";
        }
      }

    }
    return stack.isEmpty() ? "YES" : "NO";
  }
}
