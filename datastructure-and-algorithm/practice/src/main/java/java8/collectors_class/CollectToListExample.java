package java8.collectors_class;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectToListExample {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Mumbai", "Delhi", "Bangalore", "Chennai");

        // Collecting the stream into a List
        List<String> cityList = cities.stream().collect(Collectors.toList());

        System.out.println(cityList);
    }
}
