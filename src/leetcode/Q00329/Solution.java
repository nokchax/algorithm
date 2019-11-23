package leetcode.Q00329;

import java.util.Arrays;

public class Solution {
    private final int[] mx = new int[]{1, 0, -1, 0};
    private final int[] my = new int[]{0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;

        int longestPath = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];

        for(int i = 0 ; i < matrix.length ; ++i)
            Arrays.fill(cache[i], 0);

        for(int y = 0 ; y < matrix.length ; ++y) {
            for(int x = 0 ; x < matrix[0].length ; ++x) {
                longestPath = Math.max(longestPath, dfs(y, x, matrix, cache));
            }
        }

        return longestPath;
    }

    private int dfs(int y, int x, int[][] matrix, int[][] cache) {
        if(cache[y][x] > 0)
            return cache[y][x];

        int longestPath = 0;
        for(int direction = 0 ; direction < mx.length ; ++direction) {
            int ny = y + my[direction];
            int nx = x + mx[direction];

            if(ny < 0 || nx < 0 || ny >= matrix.length || nx >= matrix[0].length || matrix[y][x] >= matrix[ny][nx])
                continue;

            longestPath = Math.max(longestPath, dfs(ny, nx, matrix, cache));
        }

        return cache[y][x] = longestPath + 1;
    }
}
