package leetcode.Q00832;

public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int half = A[0].length / 2;
        int limit = A[0].length - 1;

        for(int y = 0 ; y < A.length ; ++y) {
            for(int x = 0 ; x < half ; ++x) {
                int temp = A[y][x];
                A[y][x] = A[y][limit - x];
                A[y][limit - x] = temp;
            }
        }

        for(int y = 0 ; y < A.length ; ++y) {
            for(int x = 0 ; x < A[0].length ; ++x) {
                A[y][x] = 1 - A[y][x];
            }
        }

        return A;
    }
}
