package leetcode.Q00442;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; ++i) {
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] < 0)
                answer.add(Math.abs(idx + 1));

            nums[idx] = - nums[idx];
        }

        return answer;
    }
}
