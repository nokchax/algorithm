package leetcode.Q01359;

public class Solution {
    public int countOrders(int n) {
        long answer = 1;

        for(int i = 2 ; i <= n ; ++i) {
            answer = answer * (2 * i - 1) * i % 1000000007;
        }

        return (int) answer;
    }
}
