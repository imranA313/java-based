package java8.stream_API;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Imran","Ibne", "Rehan", "Sahil", "Asfak", "Ayan");

        names.parallelStream()
                .forEach(name -> System.out.println(name + " - " + Thread.currentThread().getName()));
    }
}
