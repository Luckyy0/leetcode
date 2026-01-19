package leetcode.P253_MeetingRoomsII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    /**
     * Problem 253: Meeting Rooms II
     * Approach: Min-Heap
     * 
     * Theoretical Basis:
     * - Track end times of active meetings.
     * - If earliest ending meeting ends before new one starts, reuse room (poll).
     * - Otherwise need new room (don't poll).
     * - Always add new meeting end time.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap stores end times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add first meeting
        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // Check if earliest ending meeting is finished by the time current starts
            if (intervals[i][0] >= pq.peek()) {
                pq.poll(); // Free up the room
            }
            // Add current meeting's end time (either to new room or reused room)
            pq.add(intervals[i][1]);
        }

        return pq.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[0,30],[5,10],[15,20]] -> 2
        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        runTest(solution, intervals1, 2);

        // [[7,10],[2,4]] -> 1
        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        runTest(solution, intervals2, 1);
    }

    private static void runTest(Solution s, int[][] intervals, int expected) {
        int result = s.minMeetingRooms(intervals);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
