package leetcode.Q00048;

public class Solution {
    public void rotate(int[][] matrix) {

        for(int y = 0 ; y < matrix.length / 2 ; ++y) {
            for(int x = y ; x < matrix.length ; ++x) {
                rotateOne(y, x, matrix);
            }
        }
    }

    private void rotateOne(int y, int x, int[][] matrix) {
        int temp = matrix[y][x];
    }
}
