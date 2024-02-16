package DynamicProgramming.TwoD;

import java.util.Arrays;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, m - 1, grid, dp);
    }

    public int solve(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0)
            return grid[i][j];
        if (i < 0 || j < 0)
            return 1000;

        if (dp[i][j] != -1)
            return dp[i][j];
        int up = grid[i][j] + solve(i - 1, j, grid, dp);
        int left = grid[i][j] + solve(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

}
