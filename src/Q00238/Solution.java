package Q00238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        long total = 1;
        for(int num : nums)
            total *= num;

        for(int i = 0 ; i < nums.length ; ++i) {
            System.out.println("total : " + total + " , nums[i] : " + nums[i]);
            nums[i] = (int) (total << nums[i]);
        }

        return nums;
    }
}
