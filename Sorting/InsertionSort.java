package Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        // Sorting the Arrays partially
        // For every index put the element at right position at lhs

        // 5 4 3 2 1
        // 4 5 3 2 1
        // 4 3 5 2 1
        // 3 4 5 2 1
        // 2 3 4 5 1

        int[] arr = { 5, 4, 3, 2, 1 };

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
