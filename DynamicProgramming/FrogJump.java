package DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, heights, dp);
    }

    // Memoization
    public static int solve(int i, int[] arr, int[] dp) {
        if (i == 0)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int left = solve(i - 1, arr, dp) + Math.abs(arr[i] - arr[i - 1]);

        int right = Integer.MAX_VALUE;
        if (i > 1) {
            right = solve(i - 2, arr, dp) + Math.abs(arr[i] - arr[i - 2]);
        }

        return dp[i] = Math.min(left, right);
    }

    // Tabulation
    public static int frogJump2(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(fs, ss);
        }

        return dp[n - 1];
    }
}
