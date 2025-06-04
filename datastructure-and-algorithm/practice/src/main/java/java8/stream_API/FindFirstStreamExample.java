package java8.stream_API;

import java.util.Arrays;
import java.util.List;

public class FindFirstStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Imran", "Rehan", "Sahil", "Asfak");

        String firstName = names.stream().findFirst().orElse("No name");

        System.out.println("First name: " + firstName);
    }
}
