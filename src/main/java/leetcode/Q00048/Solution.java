package leetcode.Q00048;

public class Solution {
    public void rotate(int[][] matrix) {

        for(int y = 0 ; y < matrix.length / 2 ; ++y) {
            for(int x = y ; x < matrix.length - 1 - y ; ++x) {
                rotateOne(y, x, matrix);
            }
        }

        for(int y = 0 ; y < matrix.length ; ++y) {
            for(int x = 0 ; x < matrix.length ; ++x) {
                System.out.print(matrix[y][x] + " ");
            }
            System.out.println();
        }
    }

    private void rotateOne(int y, int x, int[][] matrix) {
        int limit = matrix.length - 1;
        int temp = matrix[y][x];
        matrix[y][x] = matrix[limit - x][y];
        matrix[limit - x][y] = matrix[limit - y][limit - x];
        matrix[limit - y][limit - x] = matrix[x][limit - y];
        matrix[x][limit - y] = temp;
    }
}
