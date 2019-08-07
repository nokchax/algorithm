package leetcode.Q00279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int numSquares(int n) {
        if(n < 1)
            return 0;

        int[] cache = new int[n + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        int root = (int) Math.sqrt(n);
        List<Integer> candidates = new ArrayList<>(root);
        for(int i = 1 ; i <= root ; ++i)
            candidates.add(i * i);

        for(int i = 1 ; i <= n ; ++i) {
            for(int j = 0 ; j < candidates.size() ; ++j) {
                if(i - candidates.get(j) < 0)
                    continue;
                cache[i] = Math.min(cache[i], cache[i - candidates.get(j)] + 1);
            }
        }

        return cache[n];
    }
}
