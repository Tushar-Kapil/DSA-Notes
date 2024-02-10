package Recursion;

import java.util.ArrayList;

public class SubSeq {

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2 };

        subseq(0, arr, new ArrayList<>());
    }

    private static void subseq(int i, int[] arr, ArrayList<Integer> res) {
        if (i == arr.length) {
            System.out.println(res);
            return;
        }

        res.add(arr[i]);
        subseq(i + 1, arr, res);
        res.remove(res.size() - 1);
        subseq(i + 1, arr, res);
    }
}
