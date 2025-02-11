package jaehoon.section09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class StringSet {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    TreeSet<String> set = new TreeSet<>();
    for (int i = 0; i < N; i++) {
      set.add(br.readLine());
    }
    br.close();

    for (String str : set) {
      System.out.println(str);
    }
  }
}
