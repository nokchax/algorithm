package leetcode.Q00128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> integerMap = new HashMap<>(nums.length);

        int maxLength = 0;

        for(int num : nums)
            integerMap.put(num, 0);

        for(int i = 0 ; i < nums.length ; ++i) {
            int target = nums[i];
            int consecutiveLength = 0;

            //최적화 하기
            while(integerMap.containsKey(target)) {
                consecutiveLength++;
                target++;
            }

            maxLength = Math.max(maxLength, consecutiveLength);
        }

        return maxLength;
    }
}
