package leetcode.P252_MeetingRooms;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 252: Meeting Rooms
     * Approach: Sorting
     * 
     * Theoretical Basis:
     * - Sort by start time.
     * - Check if any meeting ends after the next one starts.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1)
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            // If current end time > next start time -> Overlap
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[0,30],[5,10],[15,20]] -> false
        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        runTest(solution, intervals1, false);

        // [[7,10],[2,4]] -> true (sorted: [2,4], [7,10])
        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        runTest(solution, intervals2, true);
    }

    private static void runTest(Solution s, int[][] intervals, boolean expected) {
        boolean result = s.canAttendMeetings(intervals);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
