package java8.stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Imran", "Rehan", "Sahil", "Asfak");

        // Create a stream from the list
        Stream<String> stream = names.stream();

        // Print each element using forEach
        stream.forEach(System.out::println);
    }
}
