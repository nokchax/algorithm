package leetcode.Q00189;

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= k)
            k -= nums.length;

        if(k == 0 || nums.length < 2)
            return;


        for(int i = 0 ; i < k ; ++i) {
            int temp = nums[nums.length - 1];
            for(int j = nums.length - 1 ; j > 0 ; --j)
                nums[j] = nums[j - 1];
            nums[0] = temp;
        }

    }
}
