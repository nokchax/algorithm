package leetcode.Q01535;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> deq = new LinkedList<>();
        for (int x : arr) {
            deq.addLast(x);
        }

        int totalMax = Integer.MIN_VALUE;
        for (int x : arr) {
            totalMax = Math.max(x, totalMax);
        }

        int consecutive = 0;
        int target = -1;
        while (consecutive < k) {
            if (totalMax == target) {
                return target;
            }
            int first = deq.pollFirst();
            int second = deq.pollFirst();

            int min = Math.min(first, second);
            int max = Math.max(first, second);

            deq.addFirst(max);
            deq.addLast(min);

            if (max == target) {
                consecutive++;
            } else {
                target = max;
                consecutive = 1;
            }
        }

        return target;
    }
}
