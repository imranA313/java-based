package java8.optional_class;

import java.util.Optional;

public class IsPresentExample {
    public static void main(String[] args) {
        Optional<String> opt = Optional.of("Imran");
        System.out.println(opt.isPresent());
    }
}
