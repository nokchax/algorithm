package leetcode.Q00062;

import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[n][m];
        map[0][0] = 1;
        for(int i = 0 ; i < n ; ++i)
            Arrays.fill(map[i], 1);

        for(int y = 1 ; y < n ; ++y) {
            for(int x = 1 ; x < m ; ++x) {
                map[y][x] = map[y - 1][x] + map[y][x - 1];
            }
        }

        return map[n - 1][m - 1];
    }
}
