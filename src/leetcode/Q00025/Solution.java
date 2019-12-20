package leetcode.Q00025;

import java.util.*;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> nodeQ = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();

        while(head != null) {
            int i = k;
            while(i-- > 0) {
                stack.push(head);

                if(head == null) {
                    Stack<ListNode> temp = new Stack<>();
                    while(!stack.isEmpty()) {
                        temp.push(stack.pop());
                    }

                    stack = temp;
                    break;
                }

                head = head.next;
            }

            while(!stack.isEmpty()) {
                if(nodeQ.peekLast() != null) {
                    nodeQ.peekLast().next = stack.peek();
                }
                nodeQ.add(stack.pop());
            }
        }

        if(nodeQ.peekLast() != null) {
            nodeQ.peekLast().next = null;
        }
        return nodeQ.peek();
    }
}
