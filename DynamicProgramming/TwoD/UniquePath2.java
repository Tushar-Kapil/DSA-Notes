package DynamicProgramming.TwoD;

import java.util.Arrays;

public class UniquePath2 {

    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(grid, dp, grid.length - 1, grid[0].length - 1);
    }

    public int solve(int[][] grid, int[][] dp, int i, int j) {

        if (i >= 0 && j >= 0 && grid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = solve(grid, dp, i - 1, j);
        int left = solve(grid, dp, i, j - 1);

        return dp[i][j] = up + left;
    }

}
