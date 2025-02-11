package mission1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericIntersection {
    public static <T extends Comparable<? super T>> Set<T> findCommonElement(List<? extends T> list1, List<? extends T> list2) {
        Set<T> set1 = new HashSet<>(list1);
        set1.retainAll(list2);

        return set1;
    }
}
