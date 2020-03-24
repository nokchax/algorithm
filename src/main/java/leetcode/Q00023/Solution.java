package leetcode.Q00023;

import leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Map<Integer, NodeInfo> map = new HashMap<>();

        for(ListNode node : lists) {
            while(node != null) {
                ListNode curNode = node;
                if (map.containsKey(node.val)) {
                    NodeInfo curNodeInfo = map.get(node.val);

                    ListNode endNode = curNodeInfo.endNode;
                    endNode.next = node;
                    curNodeInfo.endNode = node;
                } else {
                    map.put(node.val, new NodeInfo(node));
                    queue.add(node.val);

                }
                node = node.next;
                curNode.next = null;
            }
        }

        if(queue.isEmpty())
            return null;

        ListNode startNode = map.get(queue.peek()).startNode;
        ListNode endNode = map.get(queue.poll()).endNode;

        while(!queue.isEmpty()) {
            NodeInfo curNode = map.get(queue.poll());
            endNode.next = curNode.startNode;
            endNode = curNode.endNode;
        }
        return startNode;
    }

    protected class NodeInfo {
        protected ListNode startNode;
        protected ListNode endNode;

        NodeInfo(ListNode node) {
            this.startNode = node;
            this.endNode = node;
        }
    }
}
