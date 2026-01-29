package leetcode.P435_NonOverlappingIntervals;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 435: Non-overlapping Intervals
     * Approach: Greedy (Sort by End Time)
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1) or O(log N) for sorting
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 1; // Count of non-overlapping intervals
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // No overlap
                count++;
                end = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [[1,2],[2,3],[3,4],[1,3]] -> 1
        int[][] intervals1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        runTest(sol, intervals1, 1);

        // [[1,2],[1,2],[1,2]] -> 2
        int[][] intervals2 = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        runTest(sol, intervals2, 2);

        // [[1,2],[2,3]] -> 0
        int[][] intervals3 = { { 1, 2 }, { 2, 3 } };
        runTest(sol, intervals3, 0);
    }

    private static void runTest(Solution sol, int[][] intervals, int expected) {
        int result = sol.eraseOverlapIntervals(intervals);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
