package java8.optional_class;

import java.util.Optional;

public class OrElseGetExample {
    public static void main(String[] args) {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "Imran");
        System.out.println(name);
    }
}
