package java8.stream_API;

import java.util.Arrays;
import java.util.List;

public class SortedStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Imran", "Rehan", "Sahil", "Asfak");
        names.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
