package leetcode.Q00021;



public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        else if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        ListNode mergedTail = l1.val < l2.val ? l1 : l2;
        ListNode mergedHead = mergedTail;
        if(l1.val < l2.val)
            l1 = l1.next;
        else
            l2 = l2.next;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                mergedTail.next = l1;
                l1 = l1.next;
            } else {
                mergedTail.next = l2;
                l2 = l2.next;
            }
            mergedTail = mergedTail.next;
        }

        if(l1 != null)
            mergedTail.next = l1;
        else
            mergedTail.next = l2;


        return mergedHead;
    }
}
