package leetcode.Q00287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int expectedSum = nums.length * (nums.length - 1) / 2;

        for(int num : nums)
            expectedSum -= num;

        return expectedSum * -1;
    }
}
