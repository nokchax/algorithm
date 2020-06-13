package leetcode.Q00045;

import java.util.Arrays;

public class Solution {
    public int jump(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;

        for (int i = 0 ; i < nums.length ; ++i) {
            int max = Math.min(i + nums[i], nums.length - 1);

            for (int j = max ; j > i ; --j) {
                if (cache[i] + 1 <= cache[j]) {
                    cache[j] = cache[i] + 1;
                } else {
                    break;
                }
            }
        }

        return cache[nums.length - 1];
    }
}
