package algorithm.sorting;

public class SelectionSort {

    public int[] sortedArray(int[] arr) {
        int len = arr.length;

        return sort(arr, len);
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    private int[] sort(int[] arr, int len) {

        for (int i = 0; i < len - 1; i++) {

            int min_idx = i;

            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                    int temp = arr[min_idx];
                    arr[min_idx] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

}
