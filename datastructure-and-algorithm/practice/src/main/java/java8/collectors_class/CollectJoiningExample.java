package java8.collectors_class;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectJoiningExample {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Bangalore", "Chennai");

        // Joining elements into a single String
        String joinedCities = cities.stream().collect(Collectors.joining(", "));

        System.out.println(joinedCities);
    }
}
