package generic.selfMission.ex01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("apple");
        strings.add("banana");
        strings.add("peach");
        strings.add("grape");
        strings.add("kiwi");
        strings.add("orange");
        strings.add("pineapple");
        strings.add("pear");

        //1. 람다 미적용
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        }.thenComparing(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }));

        //2. 람다 적용
        strings.sort((Comparator.comparingInt(String::length))
                .thenComparing(String::compareTo));

        for (String str : strings) {
            System.out.println(str);
        }
    }
}
