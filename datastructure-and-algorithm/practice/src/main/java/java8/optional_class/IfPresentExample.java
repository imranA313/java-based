package java8.optional_class;

import java.util.Optional;

public class IfPresentExample {
    public static void main(String[] args) {
        // The ifPresent API enables us to run some code on the wrapped value if it is
        // found to be non-null.
        // Before Optional, we would do something like this:
        String name = "Imran";
        if (name != null) {
            System.out.println(name.length());
        }

        Optional<String> opt = Optional.of("Imran");
        opt.ifPresent(str -> System.out.println(str.length()));
    }
}
