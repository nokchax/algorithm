package test.t6.q2;

import java.math.BigInteger;

public class Solution2 {
    private static final long LIMIT = 1_000_000_000;

    public int solution(int N, int K) {
        if (N < 0 || K < 0 || K > N) {
            return -1;
        } else if (N == K || K == 0) {
            return 1;
        } else if (N > LIMIT) {
            return -1;
        }

        if (K > N - K) {
            K = N - K;
        }

        System.out.println("N : " + N + "  /  K : " + K);

        long value = 1L;
        for (int i = 0 ; i < K ; ++i) {
            value = value * (N - i);
            value = value / (i + 1);
            System.out.println(value);

            if (value > LIMIT) {
                return -1;
            }
        }

        return value > LIMIT ? -1 : (int) value;
    }
}
