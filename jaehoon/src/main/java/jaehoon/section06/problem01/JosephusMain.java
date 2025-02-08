package jaehoon.section06.problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JosephusMain {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    List<Integer> arrayList = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      arrayList.add(i);
    }

    List<Integer> linkedList = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      linkedList.add(i);
    }

    Josephus josephusArrayList = new Josephus(arrayList);
    long startArray = System.currentTimeMillis();
    System.out.println("최종 생존자: " + josephusArrayList.lastRemainPerson(K));
    long endArray = System.currentTimeMillis();
    System.out.println("ArrayList 실행 시간: " + (endArray - startArray) + "ms");
    System.out.println();

    Josephus josephusLinkedList = new Josephus(linkedList);
    long startLinked = System.currentTimeMillis();
    System.out.println("최종 생존자: " + josephusLinkedList.lastRemainPerson(K));
    long endLinked = System.currentTimeMillis();
    System.out.println("LinkedList 실행 시간: " + (endLinked - startLinked) + "ms");
    System.out.println();

    long startLinkedIter = System.currentTimeMillis();
    System.out.println("최종 생존자: " + josephusLinkedList.lastRemainPersonIter(K));
    long endLinkedIter = System.currentTimeMillis();
    System.out.println("LinkedList + Iterator 실행 시간: " + (endLinkedIter - startLinkedIter) + "ms");
    br.close();
  }
}
