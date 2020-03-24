package leetcode.Q00509;

public class Solution {
    public int fib(int N) {
        int[] cache = new int[N + 1];

        if(N > 0)
            cache[1] = 1;
        if(N > 1)
            cache[2] = 1;

        for(int i = 3 ; i <= N ; ++i)
            cache[i] = cache[i - 1] + cache[i - 2];

        return cache[N];
    }
}
