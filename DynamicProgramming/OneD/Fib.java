package DynamicProgramming.OneD;

import java.util.Arrays;

public class Fib {

    // Without DP
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    // With Memoization O(n)
    public static int fiboMemo(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fiboMemo(n - 1, dp) + fiboMemo(n - 2, dp);
    }

    // Tabulation O(n)
    public static int fiboTab(int n, int[] dp2) {
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = dp2[i - 1] + dp2[i - 2];
        }
        return dp2[n];
    }

    // Space
    public static int fiboSpace(int n) {
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        // DP
        // 1. Recursion -> Write Reccurence
        // Steps:- 1. Express in Index, (Changing parameter) and base case 2. Perfom all
        // task 3.
        // Return requirement
        // 2. Memozation -> Top Down DP
        // 3. Tabulation Method -> Bottom Up DP

        // Simple
        System.out.println(fibo(4));

        // 0 1 1 2 3 5
        // Memoize sub problems (1d Array)
        int[] dp = new int[5];
        Arrays.fill(dp, -1);
        System.out.println(fiboMemo(4, dp));

        // Tabulation
        int[] dp2 = new int[5];
        dp2[0] = 0;
        dp2[1] = 1;
        System.out.println(fiboTab(4, dp2));

        // Space
        System.out.println(fiboSpace(4));
    }
}
