package java8.optional_class;

import java.util.Optional;

public class OrElseExample {
    public static void main(String[] args) {
        // With orElse, the wrapped value is returned if it is present and the argument
        // given to
        // orElse is returned if the wrapped value is absent
        String nullName = null;

        // If a value is present, invoke the specified consumer with the value, otherwise
        // do nothing.
        String name = Optional.ofNullable(nullName).orElse("Imran");
        System.out.println(name);
    }
}
