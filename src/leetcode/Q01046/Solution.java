package leetcode.Q01046;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones)
            pq.add(stone);

        while(pq.size() > 1) {
            int heavier = pq.poll();
            int lighter = pq.poll();

            int remain = heavier - lighter;

            if(remain != 0)
                pq.add(remain);
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
