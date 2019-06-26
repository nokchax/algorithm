package leetcode.Q00384;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    private int[] nums;
    private int[] origin;

    public Solution(int[] nums) {
        this.nums = nums;
        this.origin = nums.clone();
    }

    public int[] reset() {
        nums = origin;
        origin = origin.clone();

        return nums;
    }

    public int[] shuffle() {
        List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.shuffle(temp);

        for(int i = 0 ; i < temp.size() ; ++i)
            nums[i] = temp.get(i);

        return nums;
    }
}
