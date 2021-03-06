package test.t8.q1;

import java.util.Stack;

public class Solution {

    public long solution(String[] p) {
        Stack<Long> stack = new Stack<>();

        for (String t : p) {
            switch (t) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push((stack.pop() - stack.pop()) * -1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    long x = stack.pop();
                    long y = stack.pop();
                    stack.push(y / x);
                    break;
                default:
                    stack.push(Long.parseLong(t));
            }
        }

        return stack.pop();
    }
}
