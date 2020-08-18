package leetcode.Q00142;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode target = head;
        Set<ListNode> cache = new HashSet<>();

        while (target != null) {
            if (cache.contains(target)) {
                return target;
            }

            cache.add(target);
            target = target.next;
        }

        return null;
    }
}
