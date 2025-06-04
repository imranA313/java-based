package algorithm.sorting;

public class Solution {

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        int[] arr = {64,25,12,22,11};
        ss.printArray(arr);
        ss.printArray(ss.sortedArray(arr));
    }
}
