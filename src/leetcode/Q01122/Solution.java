package leetcode.Q01122;

import java.util.*;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr2)
            map.put(i, 0);

        List<Integer> temp = new ArrayList<>();

        for(int i : arr1) {
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                temp.add(i);
        }

        Collections.sort(temp);

        List<Integer> answer = new ArrayList<>();
        for(int i : arr2) {
            int size = map.get(i);
            for(int j = 0 ; j < size ; ++j)
                answer.add(i);
        }

        answer.addAll(temp);
        int[] ret = new int[answer.size()];
        for(int i = 0 ; i < ret.length ; ++i)
            ret[i] = answer.get(i);
        return ret;
    }
}
