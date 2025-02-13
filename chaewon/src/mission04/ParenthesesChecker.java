package collection.map.mission04;

import java.util.*;

public class ParenthesesChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> parentheses = new HashMap<>();
        parentheses.put("(", ")");
        parentheses.put("{", "}");
        parentheses.put("[", "]");

        System.out.println("괄호로만 이루어진 문자열을 입력하세요.: ");
        String str = sc.nextLine();
        String[] toArray = str.split("");

        Deque<String> checker = new ArrayDeque<>();

        for (String one : toArray) {
            if (parentheses.keySet().contains(one)) {
                checker.push(one);
            } else {
                String pop = checker.pop();
                if (!parentheses.get(pop).equals(one)) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");

        sc.close();
    }
}
