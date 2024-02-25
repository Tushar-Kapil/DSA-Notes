package DynamicProgramming.Stocks;

import java.util.Arrays;

public class Cooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(prices, 0, 1, n, dp);
    }

    public int solve(int[] prices, int i, int buy, int n, int[][] dp) {
        if (i >= n)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        if (buy == 1) {
            return dp[i][buy] = Math.max(-prices[i] + solve(prices, i + 1, 0, n, dp),
                    0 + solve(prices, i + 1, 1, n, dp));
        }

        return dp[i][buy] = Math.max(prices[i] + solve(prices, i + 2, 1, n, dp), 0 + solve(prices, i + 1, 0, n, dp));
    }
}
