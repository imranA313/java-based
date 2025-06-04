package java8.stream_API;

import java.util.Arrays;
import java.util.List;

public class LimitStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Limit the stream to 3 elements
        numbers.stream()
                .limit(3)
                .forEach(System.out::println);
    }
}
