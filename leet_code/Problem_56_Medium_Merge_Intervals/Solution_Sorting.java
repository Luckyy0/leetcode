package leet_code.Problem_56_Medium_Merge_Intervals;

import java.util.*;

public class Solution_Sorting {

    /**
     * Merges overlapping intervals.
     * Uses sorting by start time.
     * Hợp nhất các khoảng chồng lấn.
     * Sử dụng sắp xếp theo thời gian bắt đầu.
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort by start time
        // Sắp xếp theo thời gian bắt đầu
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlap: update end time
                // Chồng lấn: cập nhật thời gian kết thúc
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: add new interval
                // Không chồng lấn: thêm khoảng mới
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution_Sorting solution = new Solution_Sorting();

        // Test Case 1
        int[][] i1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] r1 = solution.merge(i1);
        System.out.println("Test Case 1: " + Arrays.deepToString(r1));
        // Expected: [[1, 6], [8, 10], [15, 18]]

        // Test Case 2
        int[][] i2 = { { 1, 4 }, { 4, 5 } };
        int[][] r2 = solution.merge(i2);
        System.out.println("Test Case 2: " + Arrays.deepToString(r2));
        // Expected: [[1, 5]]
    }
}
