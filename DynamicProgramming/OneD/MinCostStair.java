package DynamicProgramming.OneD;

import java.util.Arrays;

public class MinCostStair {
    // Memoization
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }

    public int solve(int i, int[] cost, int[] dp) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int a = cost[i] + solve(i + 1, cost, dp);
        int b = cost[i] + solve(i + 2, cost, dp);

        return dp[i] = Math.min(a, b);
    }

    // Tabulation
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }

        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[n - 1], cost[n - 2]);
    }
}
