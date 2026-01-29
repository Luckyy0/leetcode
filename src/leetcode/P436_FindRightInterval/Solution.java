package leetcode.P436_FindRightInterval;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    /**
     * Problem 436: Find Right Interval
     * Approach: TreeMap (Binary Search Tree)
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        TreeMap<Integer, Integer> startToIdx = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            startToIdx.put(intervals[i][0], i);
        }

        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> entry = startToIdx.ceilingEntry(intervals[i][1]);
            if (entry != null) {
                result[i] = entry.getValue();
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [[1,2]] -> [-1]
        int[][] intervals1 = { { 1, 2 } };
        runTest(sol, intervals1, new int[] { -1 });

        // [[3,4],[2,3],[1,2]] -> [-1, 0, 1]
        int[][] intervals2 = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
        runTest(sol, intervals2, new int[] { -1, 0, 1 });

        // [[1,4],[2,3],[3,4]] -> [-1, 2, -1]
        int[][] intervals3 = { { 1, 4 }, { 2, 3 }, { 3, 4 } };
        runTest(sol, intervals3, new int[] { -1, 2, -1 });
    }

    private static void runTest(Solution sol, int[][] intervals, int[] expected) {
        int[] result = sol.findRightInterval(intervals);
        System.out.println("Result: " + Arrays.toString(result) + " (Expected: " + Arrays.toString(expected) + ")");
        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
