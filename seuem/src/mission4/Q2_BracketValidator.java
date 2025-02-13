import java.util.Stack;

public class Q2_BracketValidator {
    public static void main(String[] args) {
        String st = "{{[[(())]]}}";
        System.out.println("solution(st) = " + solution(st));

    }

    private static String solution(String st) {
        if (st.length() % 2 != 0) {
            return "NO"; //홀수일떄 리턴하기!
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < st.length(); i++) {
            stack.push(st.charAt(i));
        }
        while (!stack.isEmpty()) {
            char openEnd = stack.removeFirst();
            char closeEnd = stack.pop();
            if (openEnd == '{' && closeEnd == '}'
                    || openEnd == '[' && closeEnd == ']' || openEnd == '(' && closeEnd == ')') {
                continue;
            }
            return "NO";
        }
        return "YES";
    }
}
