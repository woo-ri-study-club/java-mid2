import java.util.*;

public class Q2_BracketValidator {
    public static void main(String[] args) {
        String st = "{{[[(())]]}}";
        System.out.println("solution(st) = " + solution(st));

    }

    private static String solution(String st) {
        if (st.length() % 2 != 0) {
            return "NO"; //홀수일떄 리턴하기!
        }
        Map<Character, Character> map = Map.of('{', '}', '[', ']', '(', ')');
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < st.length(); i++) {
            //open bracket이 key!
            if (map.containsKey(st.charAt(i))) {
                stack.push(st.charAt(i)); //stack에 open bracket 담기
                continue;
            }
            // open bracket이 아닐경우
            if (stack.isEmpty() || (!map.get(stack.pop()).equals(st.charAt(i)))){
                return "NO";
            }
        }
        return "YES";

    }
}
