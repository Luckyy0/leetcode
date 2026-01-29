package leetcode.P729_MyCalendarI;

import java.util.TreeMap;

class MyCalendar {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Find interval starting before or at the same time as new start
        Integer prev = calendar.floorKey(start);
        if (prev != null && calendar.get(prev) > start)
            return false;

        // Find interval starting after the new start
        Integer next = calendar.ceilingKey(start);
        if (next != null && next < end)
            return false;

        calendar.put(start, end);
        return true;
    }
}
