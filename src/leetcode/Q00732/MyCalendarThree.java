package leetcode.Q00732;

import java.util.TreeMap;


// TODO: 2020-02-03 solve with segment tree
public class MyCalendarThree {
    private TreeMap<Integer, Integer> timeline = new TreeMap<>();

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        int timeLine = 0;
        int max = 0;
        for (int value : timeline.values()) {
            max = Math.max(max, timeLine += value);
        }

        return max;
    }
}
