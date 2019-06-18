package leetcode.Q00283;


public class Solution {
    public void moveZeroes(int[] nums) {
        int insertPosition = 0;
        for(int i = 0 ; i < nums.length ; ++i) {
            if(nums[i] != 0)
                nums[insertPosition++] = nums[i];
        }

        for(;insertPosition < nums.length ; ++insertPosition)
            nums[insertPosition] = 0;
    }
}
