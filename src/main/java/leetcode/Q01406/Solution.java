package leetcode.Q01406;

import java.util.Arrays;

public class Solution {
    private static final String ALICE = "Alice";
    private static final String BOB = "Bob";
    private static final String TIE = "Tie";

    public String stoneGameIII(int[] stoneValue) {
        long[] sum = new long[stoneValue.length + 1];
        long[] cache = new long[stoneValue.length + 1];
        Arrays.fill(cache, Integer.MIN_VALUE);

        cache[stoneValue.length] = 0;
        for(int i = stoneValue.length - 1 ; i >= 0; --i) {
            sum[i] += stoneValue[i] + sum[i + 1];

            int j = i;
            int cur = 0;
            for( ; j < i + 3 && j < stoneValue.length ; ++j) {
                cur += stoneValue[j];
                cache[i] = Math.max(cache[i], sum[j + 1] - cache[j + 1] + cur);
            }
        }

        return cache[0] > sum[0] - cache[0] ?
                ALICE :
                (cache[0] < sum[0] - cache[0] ? BOB : TIE);
    }
}
