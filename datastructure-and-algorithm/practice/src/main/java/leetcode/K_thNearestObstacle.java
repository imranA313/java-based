package leetcode;

import java.util.ArrayList;
import java.util.List;

public class K_thNearestObstacle {
    public static void main(String[] args) {
        int[][] arr = {{5, 5}, {4, 4}, {3, 3}};
        int k = 1;
        System.out.println(getK_thNearestObstacle(arr, k));
    }

    public static List<Integer> getK_thNearestObstacle(int[][] arr, int k) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            if (sum < 0) {
                sum += k;
                result.add(sum);
            } else {
                result.add(sum);
            }
        }
        return result;
    }
}
