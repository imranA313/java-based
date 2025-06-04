package java8.collectors_class;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectSummingIntExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Summing all integers in the list
        int sum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));

        System.out.println("Sum: " + sum);
    }
}
