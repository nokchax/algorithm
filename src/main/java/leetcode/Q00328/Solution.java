package leetcode.Q00328;

import leetcode.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode cur = head;
        if(head == null)
            return null;

        ListNode tail = null, tailsTail = null;
        ListNode prev = null;

        while(cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;

            next.next = null;

            if(tail == null) {
                tail = next;
            } else {
                tailsTail.next = next;
            }
            tailsTail = next;

            if(cur.next == null) {
                prev = cur;
                break;
            }

            cur = cur.next;
        }

        if(prev == null)
            cur.next = tail;
        else
            prev.next = tail;

        return head;
    }
}
