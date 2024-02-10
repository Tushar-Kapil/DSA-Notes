package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = { 4, 8, 7, 2, 1 };
        int end = arr.length - 1;

        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, end);

        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = (si + ei) / 2;

        mergeSort(arr, 0, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, ei, mid);
    }

    static void merge(int[] arr, int si, int ei, int mid) {
        int[] mix = new int[ei - si + 1];

        int indx1 = si;
        int indx2 = mid + 1;
        int k = 0;

        while (indx1 <= mid && indx2 <= ei) {

            if (arr[indx1] <= arr[indx2]) {
                mix[k++] = arr[indx1++];
            } else {
                mix[k++] = arr[indx2++];
            }
        }

        while (indx1 <= mid) {
            mix[k++] = arr[indx1++];
        }

        while (indx2 <= ei) {
            mix[k++] = arr[indx2++];
        }

        for (int i = 0, j = si; i < mix.length; i++, j++) {
            arr[j] = mix[i];
        }
    }
}
