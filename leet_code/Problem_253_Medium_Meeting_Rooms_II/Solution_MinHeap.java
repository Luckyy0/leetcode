package leet_code.Problem_253_Medium_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_MinHeap {

    /**
     * Finds the minimum number of conference rooms required.
     * Uses min-heap to track end times of active meetings.
     * Time: O(N log N), Space: O(N).
     * 
     * Tìm số lượng phòng họp tối thiểu cần thiết.
     * Sử dụng min-heap để theo dõi thời gian kết thúc của các cuộc họp đang diễn
     * ra.
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort by start time
        // Sắp xếp theo thời gian bắt đầu
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap stores end times
        // Min-heap lưu trữ thời gian kết thúc
        PriorityQueue<Integer> allocator = new PriorityQueue<>();

        // Add the first meeting
        // Thêm cuộc họp đầu tiên
        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If the earliest ending meeting ends before or at current meeting's start
            // it means the room is free
            // Nếu cuộc họp kết thúc sớm nhất xong trước hoặc tại thời điểm bắt đầu cuộc
            // họp, phòng đó trống
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // Add the current meeting's end time (either to a new room or the reused room)
            // Thêm thời gian kết thúc của cuộc họp hiện tại
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required
        // Kích thước của heap cho biết số phòng tối thiểu
        return allocator.size();
    }

    public static void main(String[] args) {
        Solution_MinHeap solution = new Solution_MinHeap();

        // Test Case 1: [[0,30],[5,10],[15,20]] -> 2
        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("Rooms 1: " + solution.minMeetingRooms(intervals1));

        // Test Case 2: [[7,10],[2,4]] -> 1
        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        System.out.println("Rooms 2: " + solution.minMeetingRooms(intervals2));
    }
}
