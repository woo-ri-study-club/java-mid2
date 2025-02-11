package jaehoon.section06.problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class JosephusMain {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    try {
      Josephus josephusArrayList = new Josephus(N, new ArrayList<>());
      long startArray = System.currentTimeMillis();
      System.out.println("최종 생존자: " + josephusArrayList.lastRemainPerson(K));
      long endArray = System.currentTimeMillis();
      System.out.println("ArrayList 실행 시간: " + (endArray - startArray) + "ms");
      System.out.println();

      Josephus josephusLinkedList = new Josephus(N, new LinkedList<>());
      long startLinked = System.currentTimeMillis();
      System.out.println("최종 생존자: " + josephusLinkedList.lastRemainPerson(K));
      long endLinked = System.currentTimeMillis();
      System.out.println("LinkedList 실행 시간: " + (endLinked - startLinked) + "ms");
      System.out.println();

      Josephus josephusLinkedList2 = new Josephus(N, new LinkedList<>());
      long startLinkedIter = System.currentTimeMillis();
      System.out.println("최종 생존자: " + josephusLinkedList2.lastRemainPersonIter(K));
      long endLinkedIter = System.currentTimeMillis();
      System.out.println("LinkedList + Iterator 실행 시간: " + (endLinkedIter - startLinkedIter) + "ms");
    } catch (Exception exception) {
      exception.printStackTrace();
      System.out.println("exception.getMessage() = " + exception.getMessage());
    }
    br.close();
  }
}
