package DynamicProgramming.Subseq;

class CountSubsetsK {
    public static int findWays(int num[], int k) {
        int mod = 1000000007;
        int n = num.length;
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (num[0] <= k)
            dp[0][num[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {
                int notpick = dp[i - 1][target];
                int pick = 0;

                if (num[i] <= target) {
                    pick = dp[i - 1][target - num[i]];
                }

                dp[i][target] = (notpick + pick) % mod;
            }
        }

        return dp[n - 1][k];

        // return solve(n-1, tar, num, dp);
    }

    public static int solve(int i, int target, int[] nums, int[][] dp) {
        if (target == 0) {
            return 1;
        }

        if (i == 0)
            return nums[0] == target ? 1 : 0;

        if (dp[i][target] != -1)
            return dp[i][target];

        int notpick = solve(i - 1, target, nums, dp);
        int pick = 0;

        if (nums[i] <= target) {
            pick = solve(i - 1, target - nums[i], nums, dp);
        }

        return dp[i][target] = notpick + pick;
    }
}
