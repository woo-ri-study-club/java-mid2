package collection.mission02;

import java.util.ArrayList;
import java.util.LinkedList;

public class JosephusMain {
    public static void main(String[] args) {
        Josephus josephusByArrayList = new Josephus(new ArrayList<>(), 8);
        Josephus josephusByLinkedList = new Josephus(new LinkedList<>(), 8);

        josephusByArrayList.initialize(100000);
        josephusByLinkedList.initialize(100000);

        long startTimeByArray = System.nanoTime();
        int resultByArray = josephusByArrayList.josephus();
        long endTimeByArray = System.nanoTime();

        System.out.println("===============Array List===============");
        System.out.println("결과: "+ resultByArray);
        System.out.println("시간: " + (endTimeByArray - startTimeByArray));
        System.out.println("===============Array List===============");

        long startTimeByLinked = System.nanoTime();
        int resultByLinked = josephusByLinkedList.josephus();
        long endTimeByLinked = System.nanoTime();

        System.out.println("===============Linked List===============");
        System.out.println("결과: "+ resultByLinked);
        System.out.println("시간: " + (endTimeByLinked - startTimeByLinked));
        System.out.println("===============Linked List===============");


        /**
         * - 실행 결과 -
         * ArrayList : 266382700
         * LinkedList: 4062210500
         *
         * - 실행 결과에 대한 분석 -
         *
         * total이 100 정도 일때의 차이는 굉장히 미미했지만, 10000 이상부터는 유의미한 차이가 보이기 시작했다.
         * 결과적으로, 요세푸스 문제 풀이에는 ArrayList가 더 효율적이었다.
         * 문제 특성 상 중간 부분에서의 요소 삭제를 반복해야 하는데,
         * 강의에서 배운 표에 의거했을 때 평균 삭제 시 배열 리스트에 비해 연결 리스트가 압도적으로 느리다.
         *
         * 추가적으로 마지막에 .get(0)를 리턴할 때의 시간 복잡도 차이도 영향을 상당 부분 끼칠 것으로 보인다.
         */
    }
}
