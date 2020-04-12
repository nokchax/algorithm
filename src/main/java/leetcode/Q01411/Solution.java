package leetcode.Q01411;

public class Solution {
    private static final int MOD = 1000000007;

    public int numOfWays(int n) {
        long twoColorCase = 6;
        long threeColorCase = 6;

        for(int i = 2 ; i <= n ; ++i) {
            long tempThreeColorCase = threeColorCase;

            threeColorCase = (2 * threeColorCase + 2 * twoColorCase) % MOD;
            twoColorCase = (2 * tempThreeColorCase + 3 * twoColorCase) % MOD;
        }

        return (int) (threeColorCase + twoColorCase) % MOD;
    }
}
