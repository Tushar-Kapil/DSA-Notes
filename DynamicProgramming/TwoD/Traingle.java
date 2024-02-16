package DynamicProgramming.TwoD;

import java.util.List;

public class Traingle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[n][i] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

}
