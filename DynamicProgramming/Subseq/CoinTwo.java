package DynamicProgramming.Subseq;

import java.util.Arrays;

public class CoinTwo {

    public int change(int amount, int[] coins) {
        // express in ind, amount
        // all posibilties
        // sum ways

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(coins, amount, n - 1, dp);

        return ans;
    }

    public int solve(int[] coins, int amount, int ind, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        int nottake = solve(coins, amount, ind - 1, dp);
        int take = 0;

        if (coins[ind] <= amount) {
            take = solve(coins, amount - coins[ind], ind, dp);
        }

        return dp[ind][amount] = nottake + take;
    }

}
