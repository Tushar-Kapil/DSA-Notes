package DynamicProgramming.Stocks;

import java.util.Arrays;

public class BuyStock3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return solve(prices, 0, 1, n, dp, 2);
    }

    public int solve(int[] prices, int i, int buy, int n, int[][][] dp, int cap) {
        if (cap == 0)
            return 0;
        if (i == n)
            return 0;

        if (dp[i][buy][cap] != -1)
            return dp[i][buy][cap];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[i] + solve(prices, i + 1, 0, n, dp, cap),
                    0 + solve(prices, i + 1, 1, n, dp, cap));
        } else {
            profit = Math.max(prices[i] + solve(prices, i + 1, 1, n, dp, cap - 1),
                    0 + solve(prices, i + 1, 0, n, dp, cap));
        }

        return dp[i][buy][cap] = profit;
    }
}
