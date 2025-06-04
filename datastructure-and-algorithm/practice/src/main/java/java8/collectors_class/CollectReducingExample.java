package java8.collectors_class;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectReducingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Reducing the numbers to their sum
        int sum = numbers.stream().collect(Collectors.reducing(0, (a, b) -> a + b));

        System.out.println("Sum using reducing: " + sum);
    }
}
