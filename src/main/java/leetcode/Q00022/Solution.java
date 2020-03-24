package leetcode.Q00022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> answer = new ArrayList<>();
    private static int limit = 0;
    private static int total = 0;
    private static int opener = 0;
    private static int closer = 0;

    public List<String> generateParenthesis(int n) {
        limit = n;
        total = 2*n;

        dfs("");

        return answer;
    }

    public void dfs(String parenthesis) {
        if(parenthesis.length() == total) {
            answer.add(parenthesis);
            return;
        }

        if(opener < limit) {
            opener++;
            dfs(parenthesis + "(");
            opener--;
        }
        if(closer < opener) {
            closer++;
            dfs(parenthesis + ")");
            closer--;
        }

    }
}
