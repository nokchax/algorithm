package leetcode.Q00206;

import leetcode.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;

        Stack<ListNode> stack = new Stack<>();

        while(head != null) {
            stack.add(head);
            head = head.next;
        }

        ListNode newHead = stack.peek();

        while(!stack.isEmpty()) {
            ListNode cur = stack.pop();
            cur.next = stack.isEmpty() ? null : stack.peek();
        }

        return newHead;
    }
}
