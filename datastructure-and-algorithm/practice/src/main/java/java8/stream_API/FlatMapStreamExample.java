package java8.stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapStreamExample {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Imran", "Rehan"),
                Arrays.asList("Sahil", "Asfak")
        );

        // Flatten the nested list and print all names
       List<String> nameList =  nestedList.stream()
                .flatMap(List::stream).toList();

        System.out.println(nameList);
    }
}
