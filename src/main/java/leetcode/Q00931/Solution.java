package leetcode.Q00931;

public class Solution {
    public int minFallingPathSum(int[][] A) {
        int[][] cache = new int[A.length][A.length];
        for (int i = 0 ; i < A.length ; ++i) {
            cache[0][i] = A[0][i];
        }

        for (int i = 1 ; i < A.length ; ++i) {
            for (int j = 0 ; j < A.length ; ++j) {
                int left = j == 0 ? 0 : j - 1;
                int right = j == A.length - 1 ? A.length - 1 : j + 1;
                int min = Math.min(Math.min(cache[i - 1][left], cache[i - 1][j]), cache[i - 1][right]);
                cache[i][j] = A[i][j] + min;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < A.length ; ++i) {
            min = Math.min(cache[A.length - 1][i], min);
        }

        return min;
    }
}
