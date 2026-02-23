package leet_code.Problem_57_Medium_Insert_Interval;

import java.util.*;

public class Solution_Linear {

    /**
     * Inserts a new interval into sorted non-overlapping intervals.
     * Uses a single-pass linear approach.
     * Chèn một khoảng mới vào các khoảng đã sắp xếp không chồng lấn.
     * Sử dụng phương pháp duyệt tuyến tính một lần.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add intervals that come before newInterval
        // Thêm các khoảng đứng trước newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        // Hợp nhất các khoảng bị chồng lấn
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 3. Add remaining intervals
        // Thêm các khoảng còn lại
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution_Linear solution = new Solution_Linear();

        // Test Case 1
        int[][] i1 = { { 1, 3 }, { 6, 9 } };
        int[] ni1 = { 2, 5 };
        System.out.println("Test Case 1: " + Arrays.deepToString(solution.insert(i1, ni1)));
        // Expected: [[1, 5], [6, 9]]

        // Test Case 2
        int[][] i2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] ni2 = { 4, 8 };
        System.out.println("Test Case 2: " + Arrays.deepToString(solution.insert(i2, ni2)));
        // Expected: [[1, 2], [3, 10], [12, 16]]
    }
}
