package leet_code.Problem_757_Hard_Set_Intersection_Size_At_Least_Two;

import java.util.Arrays;

public class Solution {

    /**
     * Finds min size of containing set.
     * Strategy: Greedy selection with sorting.
     * Time: O(N log N), Space: O(1) (excluding sort stack).
     */
    public int intersectionSizeTwo(int[][] intervals) {
        // Sort by end ascending, then by start descending
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int count = 0;
        int p1 = -1; // Second to last point picked
        int p2 = -1; // Last point picked

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Check how many existing points (p1, p2) fall within [start, end]
            boolean p1In = (p1 >= start && p1 <= end);
            boolean p2In = (p2 >= start && p2 <= end);

            if (p1In && p2In) {
                // Already have 2 points, do nothing
                continue;
            } else if (p2In) {
                // Have 1 point (p2), need 1 more
                // Pick the logic: p2 is inside. p1 is outside (likely < start).
                // We pick 'end'.
                // New configuration: old_p2 and new_end.
                // We must update p1 and p2 such that p1 < p2.
                // The points are {p2, end}. So p1 becomes p2, p2 becomes end.
                count++;
                p1 = p2;
                p2 = end;
            } else {
                // Have 0 points (both < start)
                // Need 2 points. Pick 'end-1' and 'end'.
                count += 2;
                p1 = end - 1;
                p2 = end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals1 = { { 1, 3 }, { 1, 4 }, { 2, 5 }, { 3, 5 } };
        System.out.println("Result 1: " + sol.intersectionSizeTwo(intervals1)); // 3

        int[][] intervals2 = { { 1, 2 }, { 2, 3 }, { 2, 4 }, { 4, 5 } };
        System.out.println("Result 2: " + sol.intersectionSizeTwo(intervals2)); // 5
    }
}
