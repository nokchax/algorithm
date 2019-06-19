package leetcode.Q00347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] temp = new List[nums.length + 1];

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(int key : map.keySet()) {
            int frequency = map.get(key);

            if(temp[frequency] == null)
                temp[frequency] = new ArrayList<>();

            temp[frequency].add(key);
        }

        List<Integer> answer = new ArrayList<>();
        for(int i = nums.length ; i >= 0 && answer.size() < k ; --i) {
            if(temp[i] != null)
                answer.addAll(temp[i]);
        }


        return answer;
    }
}
