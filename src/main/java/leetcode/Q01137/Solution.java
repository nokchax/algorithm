package leetcode.Q01137;

public class Solution {
    public int tribonacci(int n) {
        if(n < 2)
            return n;

        int[] cache = new int[n + 1];

        cache[1] = cache[2] = 1;

        for(int i = 3 ; i <= n ; ++i)
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];

        return cache[n];
    }
}
