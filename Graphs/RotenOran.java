package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class RotenOran {

    class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int time = 0;
        int[] dirRow = { -1, 0, 1, 0 };
        int[] dirCol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int currTime = q.peek().time;
            time = Math.max(time, currTime);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nrow = row + dirRow[i];
                int ncol = col + dirCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 2) {
                    q.add(new Pair(nrow, ncol, time + 1));
                    vis[nrow][ncol] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] != 2 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}