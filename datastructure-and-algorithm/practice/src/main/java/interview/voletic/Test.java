package interview.voletic;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String st = "iiimzranansari";

        List<Character> list = new ArrayList<>();
        for (int i = 0; i <st.length()-1 ; i++) {
            for(int j = i+1 ; j < st.length(); j++){
                if(st.charAt(i) == st.charAt(j)){
                    list.add(st.charAt(i));
                }
            }
        }
        System.out.println(list.get(1));
    }
}
