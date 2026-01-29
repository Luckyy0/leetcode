package leetcode.P732_MyCalendarIII;

import java.util.TreeMap;

class MyCalendarThree {
    private TreeMap<Integer, Integer> timeline;

    public MyCalendarThree() {
        timeline = new TreeMap<>();
    }

    public int book(int start, int end) {
        // Mark boundaries
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);

        int maxK = 0;
        int active = 0;
        for (int v : timeline.values()) {
            active += v;
            maxK = Math.max(maxK, active);
        }

        return maxK;
    }
}
