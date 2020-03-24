package leetcode.Q01289;

public class Solution {
    public int minFallingPathSum(int[][] arr) {
        int[][] cache = new int[arr.length][arr[0].length];

        //init
        for(int i = 0 ; i < arr[0].length ; ++i) {
            cache[0][i] = arr[0][i];
        }

        for(int row = 1 ; row < arr.length ; ++row) {
            for(int col = 0 ; col < arr[0].length ; ++col) {
                cache[row][col] = arr[row][col] + getMinValueOfRow(cache, arr, row - 1, col);
            }
        }

        return getMinValueOfRow(cache, arr, arr.length - 1, -1);
    }

    private int getMinValueOfRow(int[][] cache, int[][] arr, int row, int exceptCol) {
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr[0].length ; ++i) {
            if(exceptCol == i) {
                continue;
            }

            min = Math.min(min, cache[row][i]);
        }

        return min;
    }
}
