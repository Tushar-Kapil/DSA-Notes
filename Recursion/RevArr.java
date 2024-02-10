package Recursion;

import java.util.Arrays;

public class RevArr {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        reverse(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        reverse(arr, l + 1, r - 1);
    }
}
