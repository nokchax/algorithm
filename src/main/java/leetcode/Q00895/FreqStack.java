package leetcode.Q00895;

import java.util.*;

public class FreqStack {
    PriorityQueue<IntegerInfo> pq;
    Map<Integer, IntegerInfo> map;
    int stackCount = 0;

    public FreqStack() {
        this.pq = new PriorityQueue<>();
        this.map = new HashMap<>();
    }

    public void push(int x) {
        IntegerInfo info;
        if(map.containsKey(x)) {
            info = map.get(x);
            pq.remove(info);
            info.stack.push(stackCount++);
        } else {
            info = new IntegerInfo(x, stackCount++);
            map.put(x, info);
        }

        pq.add(info);
        //System.out.println("PUSH : " + x + " / TOP : " + pq.peek().number);
    }

    public int pop() {
        IntegerInfo integerInfo = pq.peek();
        pq.remove(integerInfo);
        integerInfo.stack.pop();
        if(!integerInfo.stack.isEmpty()) {
            pq.add(integerInfo);
        } else {
            map.remove(integerInfo.number);
        }

        //System.out.println("POP : " + integerInfo.number + " / TOP : " + pq.peek().number);
        return integerInfo.number;
    }

    protected class IntegerInfo implements Comparable<IntegerInfo> {
        int number;
        Stack<Integer> stack = new Stack<>();

        public IntegerInfo(int number, int position) {
            this.number = number;
            stack.push(position);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntegerInfo that = (IntegerInfo) o;
            return number == that.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public int compareTo(IntegerInfo o) {
            if(this.stack.size() == o.stack.size()) {
                return o.stack.peek() - this.stack.peek();
            }

            return o.stack.size() - this.stack.size();
        }
    }
}
