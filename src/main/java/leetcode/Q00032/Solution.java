package leetcode.Q00032;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<String> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                numStack.push("(");
                charStack.push('(');
                continue;
            }

            // c == ')'
            if(charStack.isEmpty()) {
                numStack.push(")");
            } else { // stack.peek() == '(';
                charStack.pop();
                int temp = 2;

                while(!numStack.isEmpty() && !numStack.peek().equals("(")) {
                    int num = Integer.parseInt(numStack.pop());
                    temp += num;
                }

                if(!numStack.isEmpty()) {
                    numStack.pop();
                }
                numStack.push(String.valueOf(temp));
            }
        }

        while(!numStack.isEmpty()) {
            int temp = 0;

            while(!numStack.isEmpty() && !numStack.peek().equals("(") && !numStack.peek().equals(")")) {
                int num = Integer.parseInt(numStack.pop());
                temp += num;
            }

            if(!numStack.isEmpty()) {
                numStack.pop();
            }
            max = Math.max(max, temp);
        }

        return max;
    }
}
