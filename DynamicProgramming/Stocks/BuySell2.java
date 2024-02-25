package DynamicProgramming.Stocks;

import java.util.Arrays;

public class BuySell2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(prices, 0, 1, n, dp);
    }

    public int solve(int[] prices, int i, int buy, int n, int[][] dp) {
        if (i == n)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[i] + solve(prices, i + 1, 0, n, dp), 0 + solve(prices, i + 1, 1, n, dp));
        } else {
            profit = Math.max(prices[i] + solve(prices, i + 1, 1, n, dp), 0 + solve(prices, i + 1, 0, n, dp));
        }

        return dp[i][buy] = profit;
    }
}
