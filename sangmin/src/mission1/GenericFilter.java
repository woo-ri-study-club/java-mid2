package mission1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericFilter {
    private static <T> List<T> filterList(List<T> list, Predicate<T> condition) {
        return list.stream().filter(condition).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
        List<Integer> evenNumbers = filterList(numbers, n -> n % 2 == 0);

        System.out.println("Even Numbers: " + evenNumbers); // [10, 20, 30]

        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        List<String> wordsWithA = filterList(words, w -> w.contains("a"));

        System.out.println("Words with 'a': " + wordsWithA); // ["Banana"]
    }
}
