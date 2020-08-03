package leetcode.Q01512;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int num : nums) {
            cache.put(num, cache.getOrDefault(num, 0) + 1);
        }

        int answer = 0;

        for (Integer n : cache.keySet()) {
            if (cache.get(n) > 1) {
                answer += combination(cache.get(n));
            }
        }

        return answer;
    }

    private int combination(int n) {
        System.out.println(n + " : " + n * (n - 1) / 2);
        return n * (n - 1) / 2;
    }
}
