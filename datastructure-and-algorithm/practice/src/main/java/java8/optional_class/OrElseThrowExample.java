package java8.optional_class;

import java.util.Optional;

public class OrElseThrowExample {
    public static void main(String[] args) {
        String value = "Imran";
        String name = Optional.ofNullable(value)
                .orElseThrow(IllegalArgumentException::new);
        System.out.println(name);
    }
}
