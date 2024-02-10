package Graphs.Algorithms;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int iniColor = image[sr][sc];
        int[] dirRow = { -1, 0, 1, 0 };
        int[] colRow = { 0, 1, 0, -1 };

        dfs(ans, image, sr, sc, color, iniColor, dirRow, colRow);
        return ans;
    }

    public void dfs(int[][] ans, int[][] image, int row, int col, int color, int iniColor, int[] dirRow, int[] colRow) {
        ans[row][col] = color;

        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + colRow[i];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] == iniColor
                    && ans[newRow][newCol] != color) {
                dfs(ans, image, newRow, newCol, color, iniColor, dirRow, colRow);
            }
        }
    }
}
