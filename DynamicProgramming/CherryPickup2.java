package DynamicProgramming;

public class CherryPickup2 {

    public int cherryPickup(int[][] grid) {
        // 1. Express in terms of i, j1 (Robot1) and i,j2 (Robot2)
        // common i both move to next row at same time
        // 2. Explore all the paths
        // 3. Mazimum sum possible
        // Fixed starting and varibale end so write recursion from starting point
        // f(0, 0, m-1)
        // base cases -> out of bound and destination
        // last col check postion if j1 == j2 return one else sum
        // 9 combos
        // dj[] = {-1,0,1}
        // if j1 == j2 add once otherwise both f(i+1, j1+dj1, i+1, j1+dj2);
        // For Tabulation
        // 1. Write Base case
        // 2. express every state in for loop, 3 states 3 nested loops
        //

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                } else {
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = -99999;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;
                            if (j1 == j2) {
                                value = grid[i][j1];
                            } else {
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            } else {
                                value += -99999;
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m - 1];

        // for(int[][] r1 : dp){
        // for(int[] r2 : r1){
        // Arrays.fill(r2, -1);
        // }
        // }

        // return solve(0, 0, c-1, r, c, grid, dp);
    }

    public int solve(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c)
            return -99999;

        if (i == r - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int maxi = -99999;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2) {
                    value += grid[i][j1];
                } else {
                    value += grid[i][j1] + grid[i][j2];
                }
                value += solve(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;

    }

}
