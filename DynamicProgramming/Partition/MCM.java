package DynamicProgramming.Partition;

import java.util.Arrays;

public class MCM {

    public static int matrixMultiplication(int[] arr, int N) {
        int[][] dp = new int[N][N];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(1, N - 1, arr, dp);
    }

    public static int solve(int i, int j, int[] arr, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = (int) 1e9;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + solve(i, k, arr, dp) + solve(k + 1, j, arr, dp);
            if (steps < mini)
                mini = steps;
        }

        return dp[i][j] = mini;
    }
}
