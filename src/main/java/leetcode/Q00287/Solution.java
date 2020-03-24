package leetcode.Q00287;

public class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0 ; i < nums.length ; ++i) {
            int target = nums[i];
            for(int j = i + 1 ; j < nums.length ; ++j) {
                if(target == nums[j])
                    return target;
            }
        }

        return -1;
    }
}
