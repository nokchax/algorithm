package Q00268;

public class Solution {
    public int missingNumber(int[] nums) {
        boolean[] exist = new boolean[nums.length + 1];

        for(int num : nums)
            exist[num] = true;

        for(int i = 0 ; i <= nums.length ; ++i)
            if(!exist[i])
                return i;

        return -1;
    }
}
