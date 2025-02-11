package mission04;

import java.util.*;

public class Quiz02Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(isValidBrackets(input) ? "YES" : "NO");
    }

    private static boolean isValidBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else if (c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(')
                        || (c == '}' && top != '{')
                        || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
