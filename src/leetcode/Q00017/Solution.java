package leetcode.Q00017;

import java.util.*;

public class Solution {
    private static char[][] letters = {
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return Collections.emptyList();

        Set<String> set = new HashSet<>();

        dfs(set, new StringBuilder(), digits, 0);

        List<String> answer = new ArrayList<>(set.size());
        answer.addAll(set);

        return answer;
    }

    private void dfs(Set<String> set, StringBuilder temp, String digits, int position) {
        if(position >= digits.length()) {
            set.add(temp.toString());
            return;
        }

        int charPosition = digits.charAt(position) - '1';
        int length = letters[charPosition].length;

        for(int i = 0 ; i < length ; ++i) {
            temp.append(letters[charPosition][i]);
            dfs(set, temp, digits, position + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
