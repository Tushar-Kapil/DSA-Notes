package MultidimesionalArrays;

public class RowWise {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 }, // 6
                { 4, 5, 6 }, // 15
                { 7, 8, 9 } // 24
        };

        rowSum(arr, 3, 3);
    }

    private static void rowSum(int[][] arr, int row, int col) {
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += arr[i][j];
            }
            System.out.println(sum);
        }
    }

}
