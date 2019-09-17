package leetcode.Q00204;

import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        if(n < 3)
            return 1;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[1] = isPrime[1] = false;

        for(int i = 3 ; i < n ; ++i) {
            if(!isPrime[i])
                continue;

            for(int j = 3*i ; j < n ; j += i)
                isPrime[j] = false;
        }


        int ret = 1;
        for(int i = 3 ; i < n ; ++i)
            if(isPrime[i])
                ret++;

        return ret;
    }
}
