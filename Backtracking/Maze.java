package Backtracking;

public class Maze {

    public static void main(String[] args) {
        System.out.println(pathCount(3, 3));
        path("", 3, 3);
    }

    static int pathCount(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        int left = pathCount(row - 1, col);
        int right = pathCount(row, col - 1);

        return left + right;
    }

    static void path(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);

            return;
        }

        if (row > 1) {
            path(p + "D", row - 1, col);
        }

        if (col > 1) {
            path(p + "R", row, col - 1);

        }
    }
}
