package leetcode.Q00347;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(int num : map.keySet()) {
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }

        List<Integer> answer = new ArrayList<>();

        while(!heap.isEmpty())
            answer.add(heap.poll());

        Collections.reverse(answer);
        return answer;
    }

}
