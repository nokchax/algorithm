package leetcode.Q00731;

import java.util.TreeMap;

public class MyCalendarTwo {
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarTwo() {
        this.timeline = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int delta: timeline.values()) {
            active += delta;
            if (active >= 3) {
                timeline.put(start, timeline.get(start) - 1);
                timeline.put(end, timeline.get(end) + 1);

                if (timeline.get(start) == 0) {
                    timeline.remove(start);
                }

                return false;
            }
        }
        return true;
    }
}
