package java8.collectors_class;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectCountingExample {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Bangalore", "Chennai");

        // Counting the number of cities
        long count = cities.stream().collect(Collectors.counting());

        System.out.println("Number of cities: " + count);
    }
}
