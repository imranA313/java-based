package java8.optional_class;

import java.util.Optional;

public class EmptyExample {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());

        // Optional object with the static of API:
        String name = "Ramesh";
        Optional.of(name);
    }
}
