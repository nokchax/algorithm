package leetcode.Q00007;

import java.util.Arrays;

public class Solution {
    //how about bit operation?
    public int reverse(int x) {
        char[] nums = String.valueOf(x).toCharArray();

        StringBuilder sb = new StringBuilder();
        if(nums[0] == '-') {
            sb.append('-');
            nums = Arrays.copyOfRange(nums, 1, nums.length);
        }

        for(int i = nums.length - 1 ; i >= 0 ; --i) {
            sb.append(nums[i]);
        }

        long parsedNum = Long.parseLong(sb.toString());


        if(parsedNum > (long)Integer.MAX_VALUE || parsedNum < (long)Integer.MIN_VALUE)
            return 0;


        return (int)parsedNum;
    }
}
