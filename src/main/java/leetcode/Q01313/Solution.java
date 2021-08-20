package leetcode.Q01313;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0 ; i < nums.length ; i += 2) {
            int repeat = nums[i];
            int num = nums[i + 1];
            
            for (int j = 0 ; j < repeat ; ++j) {
                answer.add(num);
            }
        }
        
        int[] array = new int[answer.size()];
        for (int i = 0; i < answer.size() ; i++) {
            array[i] = answer.get(i);
        }
        return array;
    }
}
