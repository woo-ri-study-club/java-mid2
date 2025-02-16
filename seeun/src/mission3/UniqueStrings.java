package mission3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class UniqueStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> uniqueStrings = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            uniqueStrings.add(br.readLine());
        }

        for (String string : uniqueStrings) {
            System.out.println(string);
        }

        br.close();
    }
}
