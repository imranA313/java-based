package java8.stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Imran", "Rehan", "Sahil", "Asfak");

        // Filter names that start with 'A'
       names.stream()
                .filter(name -> name.startsWith("A"))
               .forEach(System.out::println);
    }
}
