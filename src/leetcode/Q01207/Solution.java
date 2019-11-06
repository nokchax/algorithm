package leetcode.Q01207;

import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            int prevVal = map.getOrDefault(i, 0);
            map.put(i, prevVal + 1);
        }


        Integer[] list = map.values().toArray(new Integer[]{});
        Arrays.sort(list);

        int prev = list[0];
        for(int i = 1 ; i < list.length ; ++i) {
            int cur = list[i];
            if(prev == cur)
                return false;
            prev = cur;
        }

        return true;
    }
}
