package leetcode.Q00053;

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int tempSum = 0;

        for(int i = 0 ; i < nums.length ; ++i) {
            if(tempSum < nums[i])
                tempSum = Math.max(0, tempSum);

            tempSum += nums[i];
            maxSum = Math.max(maxSum, tempSum);
        }

        return maxSum;
    }
}
