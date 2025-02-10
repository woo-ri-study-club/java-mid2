package mission1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericUtil {

    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어 있습니다.");
        }

        return Collections.max(list);
    }

    public static <T extends Comparable<? super T>> List<T> mergeSortedLists(List<? extends T> list1,
                                                                             List<? extends T> list2) {
        List<T> mergedList = new ArrayList<>();
        int index1 = 0, index2 = 0;
        int size1 = list1.size(), size2 = list2.size();

        while (index1 < size1 && index2 < size2) {
            T elem1 = list1.get(index1);
            T elem2 = list2.get(index2);
            if (elem1.compareTo(elem2) <= 0) {
                mergedList.add(elem1);
                index1++;
            } else {
                mergedList.add(elem2);
                index2++;
            }
        }

        mergedList.addAll(list1.subList(index1, size1));
        mergedList.addAll(list2.subList(index2, size2));

        return mergedList;
    }

    public static <T extends Number> double average(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("잘못된 값이 들어왔습니다.");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("배열이 비어 있습니다.");
        }

        double sum = 0.0;

        for (T number : array) {
            sum += number.doubleValue();
        }

        return sum / array.length;
    }
}
