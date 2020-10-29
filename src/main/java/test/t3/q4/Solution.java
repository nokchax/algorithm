package test.t3.q4;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0 ; i < n ; ++i) {
            sb.append(depress(sc.nextLine()))
                    .append('\n');
        }

        System.out.println(sb.toString());
    }

    private static String depress(String compressed) {
        Stack<Character> stack = new Stack<>();

        for (char c : compressed.toCharArray()) {
            if (c == '[') {
                // do nothing
            } else if (c == ']') {
                // 숫자가 나올때 까지 pop 하여 임시 저장, 임시 저장된 문자열을 숫자만큼 곱하여 넣어준다
                depress(stack);
            } else {
                // 스택에 쌓는다.
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();
    }

    private static void depress(Stack<Character> stack) {
        Deque<Character> temp = new LinkedList<>();

        while (!stack.isEmpty() && !('1' <= stack.peek() && stack.peek() <= '9')) {
            temp.addFirst(stack.pop());
        }

        if (!stack.isEmpty()) {
            int x = stack.pop() - '0';

            for (int i = 0 ; i < x ; ++i) {
                temp.forEach(stack::push);
            }
        } else {
            while (!temp.isEmpty()) {
                stack.push(temp.pollFirst());
            }
        }
    }
}
