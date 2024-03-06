package Arrays;

import java.util.Arrays;

public class Pigeon {
    public static void main(String[] args) {
        int[] arr = { 24, 22, 25, 22, 21, 27 };

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int range = max - min + 1;
        int[] phole = new int[range];

        for (int i = 0; i < arr.length; i++) {
            phole[arr[i] - min]++;
        }

        int insert = 0;
        for (int i = 0; i < range; i++) {
            while (phole[i] != 0) {
                arr[insert] = i + min;
                insert++;
                phole[i]--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
