package leetcode.Q00198;

public class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1)
            return 0;

        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        if(nums.length > 1)
            cache[1] = Math.max(nums[1], nums[0]);

        for(int i = 2 ; i < nums.length ; ++i) {
            cache[i] = Math.max(nums[i] + cache[i - 2], cache[i - 1]);
        }

        return cache[nums.length - 1];
    }
}
