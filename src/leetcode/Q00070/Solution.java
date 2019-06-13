package leetcode.Q00070;

public class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];

        cache[1] = 1;
        if(n > 1)
            cache[2] = 2;

        for(int i = 3 ; i <= n ; ++i)
            cache[i] = cache[i - 1] + cache[i - 2];

        return cache[n];
    }
}
