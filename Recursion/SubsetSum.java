package Recursion;

import java.util.ArrayList;

import java.util.Collections;

public class SubsetSum {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        int n = arr.size();

        ArrayList<Integer> ans = subset(arr, n);
        System.out.println(ans);
    }

    private static ArrayList<Integer> subset(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        func(0, 0, result, arr, n);
        Collections.sort(result);
        return result;
    }

    private static void func(int ind, int sum, ArrayList<Integer> result, ArrayList<Integer> arr, int n) {
        if (ind == n) {
            result.add(sum);
            return;
        }

        func(ind + 1, sum + arr.get(ind), result, arr, n);
        func(ind + 1, sum, result, arr, n);
    }
}
