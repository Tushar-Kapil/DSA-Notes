package DynamicProgramming.TwoD;

public class NinjasTraining {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        int dp3 = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(dp3, points[0][2]);

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int pts = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], pts);
                    }
                }
            }
        }

        return dp[n - 1][3];
        // int[][] dp = new int[n][4];

        // for (int[] row : dp) {
        // Arrays.fill(row, -1);
        // }

        // return solve(n - 1, points, 3, dp);
    }

    public static int solve(int n, int[][] pts, int last, int[][] dp) {
        if (n == 0) {
            int maxi = 0;

            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, pts[0][i]);
                }
            }

            return maxi;
        }

        if (dp[n][last] != -1) {
            return dp[n][last];
        }

        int maxi = 0;

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int points = pts[n][i] + solve(n - 1, pts, i, dp);
                maxi = Math.max(maxi, points);
            }
        }
        return dp[n][last] = maxi;
    }

}