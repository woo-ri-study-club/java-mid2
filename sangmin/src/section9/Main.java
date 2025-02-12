package section9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        TreeSet<String> treeSet = new TreeSet<>();
        for (String s : list) {
            treeSet.add(s);
        }

        for (String s : treeSet) {
            System.out.println(s);
        }
    }
}
