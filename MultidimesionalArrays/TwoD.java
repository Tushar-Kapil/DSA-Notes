package MultidimesionalArrays;

import java.util.Scanner;

public class TwoD {
    public static void main(String[] args) {
        // int[][] arr = {
        // { 2, 3, 4 },
        // { 1, 5, 6 },
        // { 7, 8, 9 }
        // };
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = 0; j < arr.length; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }

        Scanner sc = new Scanner(System.in);

        int[][] arr2 = new int[2][2];

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                arr2[j][i] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();

    }

}
