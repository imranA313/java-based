package problems;

import java.util.ArrayList;
import java.util.List;

public class LongestAdjacentDigit {

    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1};
        int len = arr.length;
        int count = 1;

        List<Integer> countList = new ArrayList<>();

        for (int i = 0, j = 1; i < len - 1; i++, j++) {

            if (j + 1 != len) if ((arr[i] == 1 && arr[j] == 0 && arr[j + 1] == 1)) arr[j] = 1;

            if ((arr[i] != arr[j])) {
                countList.add(count);
                count = 1;

            } else {
                count++;
            }
        }
        if (arr[len - 1] == arr[len - 2]) {
            countList.add(count);
        }

        System.out.println(countList.get(countList.size()-1));
    }
}