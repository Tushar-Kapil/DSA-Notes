package DynamicProgramming.Subseq;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t] = 99999;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int t = 0; t <= amount; t++) {
                int nottake = 0 + dp[ind - 1][t];

                int take = Integer.MAX_VALUE;

                if (coins[ind] <= t) {
                    take = 1 + dp[ind][t - coins[ind]];
                }

                dp[ind][t] = Math.min(nottake, take);
            }
        }

        int ans = dp[n - 1][amount];

        return ans == 99999 ? -1 : ans;

        // for(int[] row : dp){
        // Arrays.fill(row, -1);
        // }

        // int res = solve(n-1, coins, amount, dp);
        // return res == 99999 ? -1 : res;
    }

    public int solve(int ind, int[] coins, int amount, int[][] dp) {

        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[ind];
            } else {
                return 99999;
            }
        }

        if (dp[ind][amount] != -1)
            return dp[ind][amount];

        int nottake = 0 + solve(ind - 1, coins, amount, dp);

        int take = Integer.MAX_VALUE;

        if (coins[ind] <= amount) {
            take = 1 + solve(ind, coins, amount - coins[ind], dp);
        }

        return dp[ind][amount] = Math.min(nottake, take);
    }
}
