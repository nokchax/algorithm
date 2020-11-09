package leetcode.Q00001;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] origin = nums.clone();
        Arrays.sort(nums);

        int frontIdx = 0;
        int rearIdx = nums.length - 1;

        while (frontIdx < rearIdx) {
            int sum = nums[frontIdx] + nums[rearIdx];

            if (sum == target) {
                break;
            } else if (sum < target) {
                frontIdx++;
            } else {
                rearIdx--;
            }
        }

        for(int i = 0 ; i < nums.length ; ++i) {
            if (origin[i] == nums[frontIdx]) {
                frontIdx = i;
                break;
            }
        }

        for(int i = nums.length - 1 ; i >= 0 ; --i) {
            if (origin[i] == nums[rearIdx]) {
                rearIdx = i;
                break;
            }
        }

        return new int[]{frontIdx, rearIdx};
    }
}
