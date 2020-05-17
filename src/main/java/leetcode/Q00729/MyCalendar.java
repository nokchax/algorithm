package leetcode.Q00729;

import java.util.TreeMap;

public class MyCalendar {
    private final TreeMap<Integer, Integer> timeline;

    public MyCalendar() {
        this.timeline = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = timeline.floorKey(start);
        Integer next = timeline.ceilingKey(start);

        if ((prev == null || timeline.get(prev) <= start) &&
                (next == null || end <= next)) {
            timeline.put(start, end);
            return true;
        }

        return false;
    }
}
