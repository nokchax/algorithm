package leetcode.Q00052;

import java.util.*;

public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> answerSet = new ArrayList<>();
        Map<Integer, String> map = init(n);

        List<String> candidate = new ArrayList<>();
        for(int i = 0 ; i < n ; ++i) {
            candidate.add(map.get(-1));
        }

        backtracking(answerSet, candidate, map, 0, n);

        return answerSet.size();
    }

    public void backtracking(List<List<String>> answerSet, List<String> candidate, Map<Integer, String> map, int row, int n) {
        if(row == n) {
            List<String> temp = new ArrayList<>(candidate.size());
            temp.addAll(candidate);

            answerSet.add(temp);
            return;
        }

        for(int i = 0 ; i < n ; ++i) {
            if(check(candidate, row, i, n)) {
                continue;
            }

            candidate.set(row, map.get(i));
            backtracking(answerSet, candidate, map, row + 1, n);
            candidate.set(row, map.get(-1));
        }
    }

    public Map<Integer, String> init(int n) {
        Map<Integer, String> map = new HashMap<>();
        char[] row = new char[n];
        for(int i = 0 ; i < n ; ++i) {
            row[i] = '.';
        }

        map.put(-1, String.valueOf(row));

        for(int i = 0 ; i < n ; ++i) {
            row[i] = 'Q';
            map.put(i, String.valueOf(row));
            row[i] = '.';
        }

        return map;
    }

    private boolean check(List<String> candidate, int row, int i, int n) {
        for(int j = 0 ; j < row ; ++j) {
            if(candidate.get(j).charAt(i) == 'Q') {
                return true;
            }
        }

        for(int j = row - 1 ; j >= 0 ; --j) {
            int right = i + (row - j);
            int left = i - (row - j);

            if(left >= 0 && candidate.get(j).charAt(left) == 'Q') {
                return true;
            }

            if(right < n && candidate.get(j).charAt(right) == 'Q') {
                return true;
            }
        }

        return false;
    }
}
