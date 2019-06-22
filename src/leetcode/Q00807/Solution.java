package leetcode.Q00807;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] horizontal = new int[grid.length];
        int[] vertical = new int[grid[0].length];

        for(int y = 0 ; y < grid.length ; ++y) {
            for(int x = 0 ; x < grid[0].length ; ++x) {
                horizontal[y] = Math.max(horizontal[y], grid[y][x]);
                vertical[x] = Math.max(vertical[x], grid[y][x]);
            }
        }


        int sum = 0;

        for(int y = 0 ; y < grid.length ; ++y)
            for(int x = 0 ; x < grid[0].length ; ++x)
                sum += Math.min(horizontal[y], vertical[x]) - grid[y][x];

        return sum;
    }
}
