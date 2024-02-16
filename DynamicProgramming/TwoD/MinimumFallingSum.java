package DynamicProgramming.TwoD;

public class MinimumFallingSum {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int z = 0; z < m; z++)
            dp[0][z] = matrix[0][z];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int s = matrix[i][j] + dp[i - 1][j];
                int l = matrix[i][j];
                if (j - 1 >= 0)
                    l += dp[i - 1][j - 1];
                else
                    l += 999999;
                int r = matrix[i][j];
                if (j + 1 < m)
                    r += dp[i - 1][j + 1];
                else
                    r += 999999;
                dp[i][j] = Math.min(s, Math.min(l, r));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }

    // public int helper(int[][] matrix, int i, int j, int n, int m, int[][] dp){
    // if(j < 0 || j >= m) return 999999;

    // if(i == 0){
    // return matrix[0][j];
    // }

    // if(dp[i][j] != -1) return dp[i][j];

    // int s = matrix[i][j] + helper(matrix, i-1, j, n, m, dp);
    // int l = matrix[i][j] + helper(matrix, i-1, j-1, n, m, dp);
    // int r = matrix[i][j] + helper(matrix, i-1, j+1, n, m, dp);

    // return dp[i][j] = Math.min(s, Math.min(l,r));
    // }

}
