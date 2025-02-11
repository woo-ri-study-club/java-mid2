package mission03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Mission3Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("입력할 문자열의 개수를 입력하세요: ");
        int N = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        System.out.println("알파벳 소문자로만 이루어진 문자열을 입력하세요.");

        HashSet<String> stringSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String inputString = sc.nextLine();
            if (inputString.length() >= 100) {
                throw new IllegalArgumentException("최대 길이는 100입니다.");
            }
            stringSet.add(inputString);
        }

        ArrayList<String> newList = new ArrayList<>(stringSet);

        newList.sort(String::compareTo);
        System.out.println("사전 순으로 정렬한 결과: " + newList);
    }
}