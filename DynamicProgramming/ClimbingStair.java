package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStair {
    // Memoization
    public int climbStairs3(int n) {
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        return countways(n, ways);
    }

    public static int countways(int n, int ways[]) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countways(n - 1, ways) + countways(n - 2, ways);
        return ways[n];
    }

    // Tabulation
    public int climbStairs2(int n) {
        if (n == 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    // Space Optimized
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 2;

        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }

        return prev2;
    }
}
