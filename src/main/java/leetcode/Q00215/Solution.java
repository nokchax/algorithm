package leetcode.Q00215;

import java.util.Collections;
import java.util.PriorityQueue;


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums)
            pq.add(num);

        while(--k > 0)
            pq.poll();

        return pq.peek();
    }
}
