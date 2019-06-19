package leetcode.Q00078;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        recursive(new ArrayList<>(), results, nums, 0);

        return results;
    }

    private void recursive(List<Integer> subset, List<List<Integer>> results, int[] nums, int startIdx) {
        results.add(new ArrayList<>(subset));

        for(int i = startIdx ; i < nums.length ; ++i) {
            subset.add(nums[i]);
            recursive(subset, results, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
