package mission04;

import java.util.*;

public class Quiz_2_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        System.out.println(isValidBrackets(input) ? "YES" : "NO");
    }

    private static boolean isValidBrackets(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map =
                Map.of(
                        '(', ')',
                        '{', '}',
                        '[', ']'
                );

        for (char c : input.toCharArray()) {

            if(map.containsKey(c)) {
                stack.push(c);
            }else if (map.containsValue(c)){
                if(stack.isEmpty()) return false;
                char top1= stack.pop();
                if(map.get(top1)!=c) return false;
            }
        }

        return stack.isEmpty();
    }
}