package leet_code.Problem_732_Hard_My_Calendar_III;

import java.util.*;

public class MyCalendarThree {
    private TreeMap<Integer, Integer> diff;

    /**
     * Initializes the calendar.
     */
    public MyCalendarThree() {
        diff = new TreeMap<>();
    }

    /**
     * Adds an event and returns the current maximum k-booking.
     * Strategy: Line Sweep with TreeMap.
     * Time: O(N) per call, Space: O(N).
     */
    public int book(int start, int end) {
        // Mark boundaries
        diff.put(start, diff.getOrDefault(start, 0) + 1);
        diff.put(end, diff.getOrDefault(end, 0) - 1);

        int maxK = 0;
        int active = 0;

        // Calculate prefix sum to find global maximum overlap
        for (int d : diff.values()) {
            active += d;
            if (active > maxK) {
                maxK = active;
            }
        }

        return maxK;
    }

    public static void main(String[] args) {
        MyCalendarThree cal = new MyCalendarThree();
        System.out.println(cal.book(10, 20)); // 1
        System.out.println(cal.book(50, 60)); // 1
        System.out.println(cal.book(10, 40)); // 2
        System.out.println(cal.book(5, 15)); // 3
        System.out.println(cal.book(5, 10)); // 3
        System.out.println(cal.book(25, 55)); // 3
    }
}
