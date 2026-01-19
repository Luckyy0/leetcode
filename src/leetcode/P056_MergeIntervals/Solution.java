package leetcode.P056_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 56: Merge Intervals
     * Approach: Sorting
     * Time Complexity: O(N log N)
     * Space Complexity: O(N) (output list)
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) { // Overlap
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] i1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] e1 = { { 1, 6 }, { 8, 10 }, { 15, 18 } };
        runTest(solution, i1, e1);

        int[][] i2 = { { 1, 4 }, { 4, 5 } };
        int[][] e2 = { { 1, 5 } };
        runTest(solution, i2, e2);
    }

    private static void runTest(Solution s, int[][] intervals, int[][] expected) {
        System.out.println("Input count: " + intervals.length);
        int[][] result = s.merge(intervals);
        System.out.println("Output count: " + result.length);

        boolean pass = Arrays.deepEquals(result, expected);
        if (pass) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            printArray(result);
        }
        System.out.println("-----------------");
    }

    private static void printArray(int[][] arr) {
        System.out.print("[");
        for (int[] a : arr)
            System.out.print(Arrays.toString(a) + ",");
        System.out.println("]");
    }
}
