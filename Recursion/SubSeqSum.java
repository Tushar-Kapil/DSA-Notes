package Recursion;

import java.util.ArrayList;

class SubSeqSum {

    public static void main(String[] args) {
        int[] arr = { 5, 9, 1, 4, 5, 6, 3 };
        int sum = 10;

        subSeqSum(0, new ArrayList<>(), 0, sum, arr.length, arr);
    }

    private static void subSeqSum(int i, ArrayList<Integer> arrayList, int s, int sum, int length, int[] arr) {
        if (i == length) {
            if (s == sum) {
                System.out.println(arrayList);
            }
            return;
        }

        arrayList.add(arr[i]);
        s += arr[i];
        subSeqSum(i + 1, arrayList, s, sum, length, arr);

        arrayList.remove(arrayList.size() - 1);
        s -= arr[i];
        subSeqSum(i + 1, arrayList, s, sum, length, arr);

    }
}