package java8.collectors_class;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectToMapExample {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Bangalore");

        // Collecting the stream into a Map (city name -> city name length)
        Map<String, Integer> cityMap = cities.stream()
                .collect(Collectors.toMap(city -> city, city -> city.length()));

        System.out.println(cityMap);
    }
}
