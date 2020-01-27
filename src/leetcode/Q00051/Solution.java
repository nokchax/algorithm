package leetcode.Q00051;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answerSet = new ArrayList<>();

        List<String> candidate = new ArrayList<>();
        for(int i = 0 ; i < n ; ++i) {
            candidate.add(mark(0, n, '.'));
        }

        backtracking(answerSet, candidate, 0, n);

        return answerSet;
    }

    public void backtracking(List<List<String>> answerSet, List<String> candidate, int row, int n) {
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
            candidate.set(row, mark(i, n, 'Q'));
            backtracking(answerSet, candidate, row + 1, n);
            candidate.set(row, mark(i, n, '.'));
        }
    }

    private String mark(int i, int n, char character) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int j = 0 ; j < n ; ++j) {
            if(i == j) {
                stringBuilder.append(character);
            }
            else {
                stringBuilder.append('.');
            }
        }

        return stringBuilder.toString();
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
