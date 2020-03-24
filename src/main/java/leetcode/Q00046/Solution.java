package leetcode.Q00046;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        permutation(answer, new ArrayList<>(), nums);

        return answer;
    }

    public void permutation(List<List<Integer>> answer, List<Integer> temp, int[] nums) {
        if(temp.size() == nums.length) {
            answer.add(new ArrayList(temp));
            return;
        }

        for(int i = 0 ; i < nums.length ; ++i) {
            if(temp.contains(nums[i]))
                continue;

            temp.add(nums[i]);
            permutation(answer, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
