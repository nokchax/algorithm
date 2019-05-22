package Q00238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        ret[0] = 1;

        for(int i = 1 ; i < nums.length ; ++i)
            ret[i] = ret[i - 1] * nums[i - 1];

        int right = 1;
        for(int i = nums.length - 2 ; i >= 0 ; --i) {
            right = right * nums[i + 1];
            ret[i] = ret[i] * right;
        }

        return ret;
    }
}
