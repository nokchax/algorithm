package main.java.leetcode.Q01463;

public class Solution {
    private static int[][] GRID;
    private static Integer[][][] CACHE;

    public int cherryPickup(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;

        GRID = grid;
        CACHE = new Integer[y][x][x];


        return dfs(y, x, 0, 0, x - 1);
    }

    private int dfs(int y, int x, int r, int left, int right) {
        if (r == y) {
            return 0;
        }

        if (CACHE[r][left][right] != null) {
            return CACHE[r][left][right];
        }

        int max = 0;
        for (int i = -1 ; i <= 1 ; ++i) {
            for (int j = -1 ; j <= 1 ; ++j) {
                int nextLeft = left + i;
                int nextRight = right + j;

                if (nextLeft >= 0 && nextLeft < x && nextRight >= 0 && nextRight < x) {
                    max = Math.max(max, dfs(y, x, r + 1, nextLeft, nextRight));
                }
            }
        }

        int rowSum = left == right ? GRID[r][left] : GRID[r][left] + GRID[r][right];

        return CACHE[r][left][right] = max + rowSum;
    }
}
