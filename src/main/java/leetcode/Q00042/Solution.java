package leetcode.Q00042;

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int frontHeight = height[0];
        int rainSum = 0;
        stack.push(height[0]);

        for(int i = 1 ; i < height.length ; ++i) {
            if(frontHeight <= height[i]) {
                while(!stack.isEmpty()) {
                    rainSum += frontHeight - stack.pop();
                }
                frontHeight = height[i];
            }
            stack.push(height[i]);
        }

        if(stack.isEmpty())
            return rainSum;


        frontHeight = stack.pop();
        while(!stack.isEmpty()) {
            if(stack.peek() <= frontHeight) {
                rainSum += frontHeight - stack.pop();
            } else {
                frontHeight = stack.peek();
            }
        }

        return rainSum;
    }
}
