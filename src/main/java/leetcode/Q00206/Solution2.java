package leetcode.Q00206;

import leetcode.ListNode;

//solving with recursive
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;

        ListNode cur = head;
        ListNode newHead = reverse(head.next, cur);
        head.next = null;

        return newHead;
    }

    private ListNode reverse(ListNode cur, ListNode prev) {
        if(cur == null)
            return prev;

        ListNode next = cur.next;
        cur.next = prev;
        return reverse(next, cur);
    }
}
