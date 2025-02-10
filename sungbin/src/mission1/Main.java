package mission1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 4, 2, 1);
        System.out.println("최대값: " + GenericUtil.max(numbers));

        List<Integer> sortedList1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> sortedList2 = Arrays.asList(2, 4, 6, 8);
        System.out.println("병합된 리스트: " + GenericUtil.mergeSortedLists(sortedList1, sortedList2));

        Double[] doubles = {1.5, 2.5, 3.5, 4.5};
        System.out.println("평균: " + GenericUtil.average(doubles));
    }
}
