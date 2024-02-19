package DynamicProgramming.Subseq;

import java.util.Arrays;

public class UnboundedKnapsack {

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, w, profit, weight, dp);
    }

    public static int solve(int ind, int w, int[] p, int[] wt, int[][] dp) {
        if (ind == 0) {
            return (w / wt[ind]) * p[ind];
        }

        if (dp[ind][w] != -1)
            return dp[ind][w];

        int nottake = 0 + solve(ind - 1, w, p, wt, dp);

        int take = Integer.MIN_VALUE;

        if (wt[ind] <= w) {
            take = p[ind] + solve(ind, w - wt[ind], p, wt, dp);
        }

        return dp[ind][w] = Math.max(nottake, take);
    }

}
