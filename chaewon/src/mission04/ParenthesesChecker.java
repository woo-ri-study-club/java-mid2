package collection.map.mission04;

import java.util.*;

public class ParenthesesChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('{', '}');
        parentheses.put('[', ']');

        System.out.println("괄호로만 이루어진 문자열을 입력하세요.: ");
        String str = sc.nextLine();
        char[] toArray = str.toCharArray();

        Deque<Character> checker = new ArrayDeque<>();

        for (char one : toArray) {
            if (parentheses.keySet().contains(one)) {
                checker.push(one);
            } else {
                if (checker.isEmpty() || !parentheses.get(checker.pop()).equals(one)) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (checker.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
