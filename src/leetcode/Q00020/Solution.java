package leetcode.Q00020;

import java.util.Stack;

public class Solution {
    private static final String open = "({[";
    private static final String close = ")}]";

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(open.indexOf(c) > -1) {
                stack.push(c);
            } else {
                if(!stack.isEmpty() && open.indexOf(stack.peek()) == close.indexOf(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
