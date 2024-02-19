package DynamicProgramming.Subseq;

import java.util.Arrays;

public class RodCutting {

    public static int cutRod(int price[], int n) {
        int ind = price.length;

        int[][] dp = new int[ind][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(ind - 1, price, n, dp);
    }

    public static int solve(int ind, int[] price, int n, int[][] dp) {
        if (ind == 0) {
            return n * price[0];
        }

        if (dp[ind][n] != -1)
            return dp[ind][n];

        int nottake = 0 + solve(ind - 1, price, n, dp);

        int take = Integer.MIN_VALUE;
        int rodlen = ind + 1;

        if (rodlen <= n) {
            take = price[ind] + solve(ind, price, n - rodlen, dp);
        }

        return dp[ind][n] = Math.max(take, nottake);
    }
}
