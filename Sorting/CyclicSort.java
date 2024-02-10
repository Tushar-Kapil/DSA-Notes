package Sorting;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {

        // For arrays given 1 to n
        // ex [5,3,2,1,4]
        // 0 1 2 3 4 --> index

        // 5 3 2 1 4
        // 4 3 2 1 5
        // 1 2 3 4 5

        // correct index = value - 1

        int arr[] = { 5, 3, 2, 1, 4 };

        cyclicSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr) {

        int start = 0;

        while (start < arr.length) {
            int correct = arr[start] - 1;

            if (arr[start] != arr[correct]) {
                swap(arr, start, correct);
            } else {
                start++;
            }
        }
    }

    static void swap(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }
}
