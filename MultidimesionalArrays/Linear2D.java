package MultidimesionalArrays;

import java.util.ArrayList;

public class Linear2D {

    public static void main(String[] args) {
        int[][] arr = {
                { 2, 3, 4 },
                { 5, 6, 7 }
        };

        ArrayList<Integer> ans = linear(arr, 3, 2, 3);
        System.out.println(ans);
    }

    static ArrayList<Integer> linear(int[][] arr, int target, int row, int col) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == target) {
                    ans.add(i);
                    ans.add(j);
                }
            }
        }

        return ans;
    }
}
