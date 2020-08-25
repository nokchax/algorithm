package leetcode.Q00946;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int target = 0;
        while (target < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[target]) {
                if (i < popped.length) {
                    stack.push(pushed[i++]);
                    continue;
                } else {
                    return false;
                }
            }

            stack.pop();
            target++;
        }

        return stack.isEmpty();
    }
}
