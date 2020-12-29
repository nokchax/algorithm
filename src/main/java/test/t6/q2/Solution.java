package test.t6.q2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
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

        Map<Position, Long> cache = new HashMap<>();

        long answer = 0;
        try {
            answer = dfs(N, K, cache);
        } catch (Exception e) {
            return -1;
        }

        return answer > LIMIT ? -1 : (int)answer;
    }


    private long dfs(int N, int K, Map<Position, Long> cache) throws Exception {
        if (N == K || K == 0) {
            return 1;
        }

        Position position = new Position(N, K);

        if (cache.containsKey(position)) {
            return cache.get(position);
        }

        long value = dfs(N - 1, K, cache) + dfs(N - 1, K - 1, cache);
        if (value > LIMIT) {
            throw new Exception();
        }
        cache.put(position, value);

        return cache.get(position);
    }

    public class Position {
        int n;
        int k;

        public Position(int n, int k) {
            this.n = n;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return n == position.n &&
                    k == position.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(n, k);
        }
    }
}
