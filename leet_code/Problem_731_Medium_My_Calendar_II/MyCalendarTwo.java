package leet_code.Problem_731_Medium_My_Calendar_II;

import java.util.*;

public class MyCalendarTwo {
    private List<int[]> calendar;
    private List<int[]> overlaps;

    /**
     * Initializes the calendar.
     */
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    /**
     * Attempts to book an event [start, end) without causing a triple booking.
     * Strategy: Two-layer overlap tracking.
     * Time: O(N), Space: O(N).
     */
    public boolean book(int start, int end) {
        // Step 1: Check if new event overlaps with existing double-bookings
        for (int[] iv : overlaps) {
            if (Math.max(start, iv[0]) < Math.min(end, iv[1])) {
                return false; // This would cause a triple booking
            }
        }

        // Step 2: New event is allowed. Identify new double-bookings for future checks.
        for (int[] iv : calendar) {
            int s = Math.max(start, iv[0]);
            int e = Math.min(end, iv[1]);
            if (s < e) {
                overlaps.add(new int[] { s, e });
            }
        }

        // Step 3: Add to successful list
        calendar.add(new int[] { start, end });
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo cal = new MyCalendarTwo();
        System.out.println(cal.book(10, 20)); // true
        System.out.println(cal.book(50, 60)); // true
        System.out.println(cal.book(10, 40)); // true (double booking)
        System.out.println(cal.book(5, 15)); // false (triple booking)
        System.out.println(cal.book(5, 10)); // true
        System.out.println(cal.book(25, 55)); // true
    }
}
