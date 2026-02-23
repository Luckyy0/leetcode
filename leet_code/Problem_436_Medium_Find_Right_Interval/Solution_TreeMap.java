package leet_code.Problem_436_Medium_Find_Right_Interval;

import java.util.*;

public class Solution_TreeMap {

    /**
     * Finds the index of the right interval for each interval.
     * Strategy: Use TreeMap for O(log N) ceiling search.
     * Time: O(N log N), Space: O(N).
     */
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // Maps start time to original index
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        for (int i = 0; i < n; i++) {
            // Find the smallest start point >= current end point
            Integer rightStart = map.ceilingKey(intervals[i][1]);

            if (rightStart != null) {
                result[i] = map.get(rightStart);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_TreeMap solution = new Solution_TreeMap();
        int[][] intervals = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
        int[] res = solution.findRightInterval(intervals);
        System.out.println("Result: " + Arrays.toString(res)); // [-1, 0, 1]
    }
}
