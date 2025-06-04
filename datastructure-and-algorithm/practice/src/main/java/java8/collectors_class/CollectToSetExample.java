package java8.collectors_class;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectToSetExample {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Mumbai", "Bangalore", "Delhi");

        // Collecting the stream into a Set
        Set<String> citySet = cities.stream().collect(Collectors.toSet());

        System.out.println(citySet);
    }
}
