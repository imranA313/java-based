package java8.stream_API;

import java.util.Arrays;
import java.util.List;

public class SkipStreamExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Skip the first 2 elements
        numbers.stream()
                .skip(2)
                .forEach(System.out::println);
    }
}
