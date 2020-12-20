package test.t7.q1;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public int[] solution(int N) {
        int x = ThreadLocalRandom.current().nextInt(1, N);
        int y = N - x;

        if (String.valueOf(x).contains("0") || String.valueOf(y).contains("0")) {
            return solution(N);
        }

        return new int[]{x, y};
    }
}
