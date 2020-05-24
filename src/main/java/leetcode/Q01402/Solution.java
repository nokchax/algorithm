package leetcode.Q01402;

import java.util.Arrays;

public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        if (satisfaction.length == 0) {
            return 0;
        }

        Arrays.sort(satisfaction);
        int result = 0;
        int curValue = 0;
        int prefix = 0;

        for (int i = satisfaction.length - 1 ; 0 <= i ; --i) {
            prefix += satisfaction[i];
            curValue += prefix;

            result = Math.max(curValue, result);
        }

        return result > 0 ? result : 0;
    }
}
