package leetcode.Q01389;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> array = new LinkedList<>();
        
        for (int i = 0 ; i < nums.length ; ++i) {
            int idx = index[i];
            array.add(idx, nums[i]);
        }
        
        int[] answer = new int[array.size()];
        for (int i = 0 ; i < array.size() ; ++i) {
            answer[i] = array.get(i);
        }
        
        return answer;
    }
}
