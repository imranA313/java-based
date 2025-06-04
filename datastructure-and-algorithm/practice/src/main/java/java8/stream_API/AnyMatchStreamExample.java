package java8.stream_API;

import java.util.Arrays;
import java.util.List;

public class AnyMatchStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Imran", "Rehan", "Sahil", "Asfak");
        // Check if any name starts with 'D'
        boolean anyMatch = names.stream()
                .anyMatch(name -> name.startsWith("r"));
        System.out.println(anyMatch);
    }
}
