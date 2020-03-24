package leetcode.Q00454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> fore = new HashMap<>();

        for(int i = 0 ; i < A.length ; ++i) {
            for(int j = 0 ; j < B.length ; ++j) {
                int temp = A[i] + B[j];
                fore.put(temp, fore.getOrDefault(temp, 0) + 1);
            }
        }

        int count = 0;
        for(int i = 0 ; i < C.length ; ++i) {
            for(int j = 0 ; j < D.length ; ++j) {
                int temp = C[i] + D[j];
                count += fore.getOrDefault(-temp, 0);
            }
        }

        return count;
    }
}
