package leetcode.Q00155;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        pq.add(x);
    }

    public void pop() {
        if(stack.isEmpty())
            return;

        pq.remove(stack.peek());
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pq.peek();
    }
}
