package java8.stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Imran", "Rehan", "Sahil", "Asfak");

        // Collect names that start with 'D' into a List
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("I"))
                .collect(Collectors.toList());

        System.out.println(filteredNames);
    }
}
