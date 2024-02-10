package MultidimesionalArrays;

import java.util.Scanner;

public class MultiDimensional {
    public static void main(String[] args) {

        /*
         * {
         * {1,2,3},
         * {4,5,6}
         * }
         */

        Scanner sc = new Scanner(System.in);

        int arr[][] = new int[2][3]; // row column

        for (int row = 0; row < arr.length; row++) {

            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = sc.nextInt();
            }
        }

        for (int row = 0; row < arr.length; row++) {

            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        sc.close();

    }
}
