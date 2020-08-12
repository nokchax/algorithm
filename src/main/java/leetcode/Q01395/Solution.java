package leetcode.Q01395;

import java.util.Stack;

// with greedy
public class Solution {
    public int numTeams(int[] rating) {
        int answer = 0;
        for (int i = 0 ; i < rating.length ; ++i) {
            Stack<Integer> candidate = new Stack<>();
            candidate.push(rating[i]);
            answer += dfs(rating, i + 1, candidate, true);
            answer += dfs(rating, i + 1, candidate, false);
        }

        return answer;
    }

    public int dfs(int[] rating, int idx, Stack<Integer> candidate, boolean order) {
        if (candidate.size() == 3) {
            return 1;
        }

        int count = 0;
        for (int i = idx ; i < rating.length ; ++i) {
            if (order) {
                if (candidate.peek() < rating[i]) {
                    continue;
                }
            } else {
                if (candidate.peek() > rating[i]) {
                    continue;
                }
            }

            candidate.push(rating[i]);
            count += dfs(rating, i + 1, candidate, order);
            candidate.pop();
        }

        return count;
    }
}
