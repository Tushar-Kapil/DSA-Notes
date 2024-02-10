package Recursion;

import java.util.ArrayList;

public class LinearS {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 6, 6, 7 };

        int target = 6;

        System.out.println(linearSearch(arr, target, 0, new ArrayList<Integer>()));
    }

    static ArrayList<Integer> linearSearch(int arr[], int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return linearSearch(arr, target, index + 1, list);

    }
}
