package leet_code.Problem_252_Easy_Meeting_Rooms;

import java.util.Arrays;

public class Solution_Sort {

    /**
     * Checks if a person can attend all meetings.
     * Uses Sorting.
     * Time: O(N log N), Space: O(1) variant (depending on sort).
     * 
     * Kiểm tra xem một người có thể tham dự tất cả các cuộc họp không.
     * Sử dụng Sắp xếp.
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        // Sort by start time using lambda
        // Sắp xếp theo thời gian bắt đầu sử dụng lambda
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < intervals.length; i++) {
            // If current meeting starts before previous meeting ends, overlap
            // Nếu cuộc họp hiện tại bắt đầu trước khi cuộc họp trước kết thúc, chồng chéo
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Sort solution = new Solution_Sort();

        // Test Case 1: [[0,30],[5,10],[15,20]] -> false
        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("Can attend 1: " + solution.canAttendMeetings(intervals1));

        // Test Case 2: [[7,10],[2,4]] -> true
        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        System.out.println("Can attend 2: " + solution.canAttendMeetings(intervals2));
    }
}
