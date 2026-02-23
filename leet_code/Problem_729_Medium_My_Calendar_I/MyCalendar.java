package leet_code.Problem_729_Medium_My_Calendar_I;

import java.util.*;

public class MyCalendar {
    private TreeMap<Integer, Integer> calendar;

    /**
     * Initializes the calendar object.
     */
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    /**
     * Attempts to book an event [start, end).
     * Strategy: Use TreeMap's floor/ceiling to check for overlaps in O(log N).
     * Time: O(log N), Space: O(N).
     */
    public boolean book(int start, int end) {
        // Find the event that starts exactly at or before 'start'
        Map.Entry<Integer, Integer> prev = calendar.floorEntry(start);
        if (prev != null && prev.getValue() > start) {
            return false; // Overlap with previous event
        }

        // Find the event that starts at or after 'start'
        Map.Entry<Integer, Integer> next = calendar.ceilingEntry(start);
        if (next != null && next.getKey() < end) {
            return false; // Overlap with next event
        }

        calendar.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // true
        System.out.println(myCalendar.book(15, 25)); // false
        System.out.println(myCalendar.book(20, 30)); // true
    }
}
