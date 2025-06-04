package java8.collectors_class;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectAveragingIntExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Calculating the average of all integers in the list
        double average = numbers.stream().collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("Average: " + average);
    }
}
