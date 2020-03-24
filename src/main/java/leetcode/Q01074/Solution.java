package leetcode.Q01074;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int answer = 0;
        int yLen = matrix.length;
        int xLen = matrix[0].length;

        for(int xx = 0 ; xx < xLen ; ++xx) {
            int[] verticalSum = new int[yLen];

            for(int x = xx ; x < xLen ; ++x) {
                Map<Integer, Integer> count = new HashMap<>();

                count.put(0, 1);
                int prefixSum = 0;

                for(int y = 0 ; y < yLen ; ++y) {
                    verticalSum[y] += matrix[y][x];
                    prefixSum += verticalSum[y];

                    answer += count.getOrDefault(prefixSum - target, 0);

                    count.put(prefixSum, count.getOrDefault(prefixSum, 0) + 1);
                }
            }
        }

        return answer;
    }
}
