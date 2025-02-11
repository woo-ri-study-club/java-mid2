import java.util.*;

public class Main {
    public static void main(String[] args) {
        /**
         * 중복없는 문자열 집합 만들기!
         *
         * 단어 갯수 입력 받고 단어들을 입력한다.
         * 소문자이고 길이는 100을 넘지 않는다.
         * 문자는 사전순으로 정렬.
         *
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("입력하실 단어의 갯수를 알려주세요.");
        int n = scanner.nextInt();

        Set<String> treeset = new TreeSet<>();
        scanner.nextLine();
        for (int i = 0; i <n; i++) {
            System.out.println("단어를 입력해주세요.");
            String string = scanner.nextLine();
            treeset.add(string);
        }
        scanner.close();
        System.out.println(treeset.toString());
    }


}
