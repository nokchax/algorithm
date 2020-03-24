package leetcode.Q00155;

import java.util.Stack;

class MinStack2 {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;

    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }

        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
