package leetcode.Q00141;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;
        while(cur.next != null) {
            if(set.contains(cur.next))
                return true;

            set.add(cur.next);
            cur = cur.next;
        }

        return false;
    }
}
