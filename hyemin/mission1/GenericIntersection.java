package mission1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericIntersection {
    public static <T extends Comparable<? super T>> List<T> findCommonElement(List<? extends T> list1, List<? extends T> list2) {
        Set<T> commonElements = new HashSet<>();

        for (T t : new HashSet<>(list1)) {
            if (list2.contains(t)) {
                commonElements.add(t);
            }
        }

        return commonElements.stream().toList();
    }
}
