package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        // Compare adjacent elements in each pass
        // Largest element is bubbled upto last position in each pass
        // Space Complexity = O(1)
        // Time Complexity = O(n^2)

        int[] arr = { 5, 4, 3, 2, 1 };

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;

                }
            }
        }
    }
}
