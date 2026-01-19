package leetcode.P057_InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 57: Insert Interval
     * Approach: Linear Scan
     * Time Complexity: O(N)
     * Space Complexity: O(N) (output)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        // While current interval starts before (or at) newInterval ends
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 3. Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] i1 = { { 1, 3 }, { 6, 9 } };
        int[] n1 = { 2, 5 };
        int[][] e1 = { { 1, 5 }, { 6, 9 } };
        runTest(solution, i1, n1, e1);

        int[][] i2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] n2 = { 4, 8 };
        int[][] e2 = { { 1, 2 }, { 3, 10 }, { 12, 16 } };
        runTest(solution, i2, n2, e2);
    }

    private static void runTest(Solution s, int[][] intervals, int[] newInterval, int[][] expected) {
        System.out.println("Input intervals count: " + intervals.length);
        int[][] result = s.insert(intervals, newInterval);

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
