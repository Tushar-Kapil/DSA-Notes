package DynamicProgramming;

public class SubsetSumToK {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        // https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0
        // 1. express in (index, target)
        // 2. Do stuff ie take | not take
        // 3. check target in array
        // f(n-1, target) checks if target is poosible in entire array.
        // base cases -> if target == 0 means found
        // if ind == 0 check if a[i] == target

        boolean[][] dp = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = notTaken || taken;
            }
        }

        return dp[n - 1][k];

    }

    public static boolean solve(int i, int target, int[] arr, int[][] dp) {
        // [1,2,3,4] k = 4;
        if (target == 0)
            return true;

        if (i == 0)
            return (arr[i] == target);

        if (dp[i][target] != -1) {
            return dp[i][target] == 0 ? false : true;
        }

        boolean not = solve(i - 1, target, arr, dp);
        boolean take = false;

        if (target >= arr[i]) {
            take = solve(i - 1, target - arr[i], arr, dp);
        }

        dp[i][target] = not || take ? 1 : 0;
        return not || take;
    }
}
