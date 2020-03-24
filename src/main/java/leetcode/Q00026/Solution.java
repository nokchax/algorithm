package leetcode.Q00026;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;

        int count = 1;
        int idx = 0;
        int before = nums[0];
        for(int i = 0 ; i < nums.length ; ++i) {
            if(before != nums[i]) {
                count++;
                before = nums[i];
                nums[++idx] = nums[i];
            }
        }

        return count;
    }
}
