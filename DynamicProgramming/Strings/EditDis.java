package DynamicProgramming.Strings;

public class EditDis {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int ins = 1 + dp[i][j - 1];
                    int del = 1 + dp[i - 1][j];
                    int rep = 1 + dp[i - 1][j - 1];
                    int insdel = Math.min(ins, del);

                    dp[i][j] = Math.min(insdel, rep);
                }
            }
        }

        return dp[n][m];

        // for(int[] row : dp){
        // Arrays.fill(row, -1);
        // }

        // return solve(word1, word2, n, m, dp);
    }

    public int solve(String word1, String word2, int i, int j, int[][] dp) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return dp[i][j] = solve(word1, word2, i - 1, j - 1, dp);
        }

        int ins = 1 + solve(word1, word2, i, j - 1, dp);
        int del = 1 + solve(word1, word2, i - 1, j, dp);
        int rep = 1 + solve(word1, word2, i - 1, j - 1, dp);
        int insdel = Math.min(ins, del);

        return dp[i][j] = Math.min(insdel, rep);
    }
}
