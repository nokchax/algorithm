package leetcode.Q00002;

import leetcode.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean addition = false;
        ListNode head = null, tail = null;

        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + (addition ? 1 : 0);
            addition = sum >= 10;
            if (addition) {
                sum -= 10;
            }

            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (addition) {
            tail.next = new ListNode(1);
        }

        return head;
    }
}
