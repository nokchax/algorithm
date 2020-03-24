package leetcode.Q00350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // intersection : 교집합
    public int[] intersect(int[] num1, int[] num2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> temp = new ArrayList<>();

        for(int num : num1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : num2) {
            if(!map.containsKey(num) || map.get(num) < 1)
                continue;

            temp.add(num);
            map.put(num, map.get(num) - 1);
        }

        int[] result = new int[temp.size()];
        for(int i = 0 ; i < result.length ; ++i)
            result[i] = temp.get(i);

        return result;
    }
}
