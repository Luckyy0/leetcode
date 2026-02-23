package leet_code.Problem_715_Hard_Range_Module;

import java.util.*;

public class RangeModule {
    private TreeMap<Integer, Integer> intervals;

    public RangeModule() {
        intervals = new TreeMap<>();
    }

    /**
     * Adds an interval and merges all overlapping ones.
     * Time: Amortized O(log N).
     */
    public void addRange(int left, int right) {
        // Find overlapping intervals
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        if (start != null && intervals.get(start) >= left) {
            left = start;
        }
        if (end != null && intervals.get(end) > right) {
            right = intervals.get(end);
        }

        // Remove all sub-intervals that fall within the new unified range
        intervals.subMap(left, right).clear();
        intervals.put(left, right);
    }

    /**
     * Checks if a range is fully covered by one existing interval.
     * Time: O(log N).
     */
    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if (start == null)
            return false;
        return intervals.get(start) >= right;
    }

    /**
     * Removes tracking for a range, potentially splitting intervals.
     * Time: Amortized O(log N).
     */
    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        // Capture parts that remain after removal
        if (end != null && intervals.get(end) > right) {
            intervals.put(right, intervals.get(end));
        }
        if (start != null && intervals.get(start) > left) {
            intervals.put(start, left);
        }

        // Clear all sub-intervals that have been targeted for removal
        intervals.subMap(left, right).clear();
    }

    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(10, 20);
        rm.removeRange(14, 16);
        System.out.println(rm.queryRange(10, 14)); // true
        System.out.println(rm.queryRange(13, 15)); // false
        System.out.println(rm.queryRange(16, 20)); // true
    }
}
