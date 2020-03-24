package leetcode.Q01021;

import java.util.Stack;

public class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> temp = new Stack<>();
        StringBuffer answer = new StringBuffer();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                if(temp.isEmpty()) {
                    temp.add(c);
                } else {
                    temp.add(c);
                    answer.append(c);
                }
            } else {
                if(temp.size() == 1)
                    temp.pop();
                else {
                    temp.pop();
                    answer.append(c);
                }
            }
        }

        return answer.toString();
    }
}
