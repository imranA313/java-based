package hackerearth.array;

public class Rotation {

    public static void main(String[] args) {

        int[] arr = {1,2};
        int n = 2;
        int k = 2;

        solution(arr, n, k);
    }

    public static void solution(int[] arr, int n, int k){

        for(int i = 0; i < k; i++){
            int last = arr[n-1];
            for(int j = n-1; j > 0; j--) arr[j] = arr[j-1];

            arr[0] = last;
        }

        for (int i = 0; i < n; i++) System.out.print(arr[i]+ " ");

    }
}
