package leetcode.Q00312;

public class Solution {
    static int[][] cache;
    static int[] NUMS;

    public int maxCoins(int[] nums) {
        cache = new int[nums.length][nums.length];
        NUMS = nums;
        int max = 0;

        for(int i = 0 ; i < nums.length ; ++i) {
            max = Math.max(max,
                            burst(0, i - 1) +
                            burst(i + 1, nums.length - 1) +
                            NUMS[i]
                    );
        }

        return max;
    }

    private int burst(int left, int right) {
        if(left < 0 || left > right || right >= cache.length)
            return 0;

        if(cache[left][right] > 0)
            return cache[left][right];

        int max = 0;

        for(int i = left ; i <= right ; ++i) {
            int sum = burst(left, i - 1) + burst(i + 1, right);
            int leftVal = left - 1 < 0 ? 1 : NUMS[left - 1];
            int rightVal = right + 1 >= cache.length ? 1 : NUMS[right + 1];
            sum += NUMS[i] * leftVal * rightVal;

            max = Math.max(max, sum);
        }

        cache[left][right] = max;

        return max;
    }
}
