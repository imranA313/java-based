package java8.stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Imran","Ibne", "Rehan", "Sahil", "Asfak", "Ayan");

        // Group names by the first letter
        Map<Character, List<String>> groupedByLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(groupedByLetter);
    }
}
