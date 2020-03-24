package leetcode.Q00378;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] indexes = new int[matrix.length];
        int current = 0;
        int minimumsIndex = indexes[0];
        int minimumsNum = Integer.MAX_VALUE;

        while(current < k) {
            minimumsNum = Integer.MAX_VALUE;
            for(int i = 0 ; i < indexes.length ; ++i) {
                if(indexes[i] >= matrix[0].length)
                    continue;
                if(matrix[i][indexes[i]] < minimumsNum) {
                    minimumsNum = matrix[i][indexes[i]];
                    minimumsIndex = i;
                }
            }
            indexes[minimumsIndex]++;
            current++;
        }

        return minimumsNum;
    }
}
