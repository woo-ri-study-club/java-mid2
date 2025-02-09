package mission1;

import java.util.List;

import static mission1.GenericIntersection.findCommonElement;

public class GenericMain {
    public static void main(String[] args) {
        List<Integer> integerList1 = List.of(1, 2, 3, 4);
        List<Integer> integerList2 = List.of(2, 4);
        List<Integer> commonIntegers = findCommonElement(integerList1, integerList2);
        System.out.println("commonIntegers = " + commonIntegers); // commonIntegers = [2, 4]

        List<String> stringList1 = List.of("1", "2", "3");
        List<String> stringList2 = List.of("1", "2", "3", "5");
        List<String> commonStrings = findCommonElement(stringList1, stringList1);
        System.out.println("commonStrings = " + commonStrings); // commonStrings = [1, 2, 3]
    }
}
