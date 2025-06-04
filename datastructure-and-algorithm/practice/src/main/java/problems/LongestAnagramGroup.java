package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LongestAnagramGroup {

    public static void main(String[] args) {
        String word = "eat tea tan ate nat bat";
        System.out.println(getLongestAnagramGroup(word.split(" ")));
    }

    public static List<String> getLongestAnagramGroup(String[] strArr){
        List<String> stringList = new ArrayList<>();
        for(String st: strArr){
            List<Character> characters = new ArrayList<>();
            for(int i = 0; i < st.length(); i++){
                characters.add(st.charAt(i));
            }
            Collections.sort(characters);
            String string = characters.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            stringList.add(string);
        }
        Collections.sort(stringList);
        List<List<String>> lists = new ArrayList<>();
        List<String> longestAnagramGroupList = new ArrayList<>();
        String temp = stringList.get(0);

        for(String s: stringList){
            if(temp.equals(s)){
                longestAnagramGroupList.add(s);
            }
            else {
                lists.add(longestAnagramGroupList);
                longestAnagramGroupList = new ArrayList<>();
                temp = s;
                longestAnagramGroupList.add(s);
            }
        }
        int max = lists.get(0).size();
        for (int i = 1; i < lists.size(); i++) {
            if(lists.get(i).size() > max){
                max = i;
            }
        }
        return lists.get(max);
    }
}
