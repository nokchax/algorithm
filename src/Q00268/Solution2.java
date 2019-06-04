package Q00268;

public class Solution2 {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;

        for(int num : nums)
            expectedSum -= num;

        return expectedSum;
    }
}
