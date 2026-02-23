package leet_code.Problem_435_Medium_Non_overlapping_Intervals;

import java.util.*;

public class Solution_Greedy {

    /**
     * Finds the minimum number of intervals to remove.
     * Strategy: Sort by end time and count non-overlapping intervals.
     * Time: O(N log N), Space: O(1).
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1; // Number of non-overlapping intervals kept
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // No overlap, keep this interval
                count++;
                end = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println("Result: " + solution.eraseOverlapIntervals(intervals)); // 1
    }
}
