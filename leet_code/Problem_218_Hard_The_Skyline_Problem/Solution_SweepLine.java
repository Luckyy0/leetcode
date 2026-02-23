package leet_code.Problem_218_Hard_The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_SweepLine {

    /**
     * Solves The Skyline Problem using the Sweep Line algorithm.
     * Uses a PriorityQueue to track active building heights.
     * Time: O(N^2) worst case due to PQ.remove(), O(N log N) average.
     * 
     * Giải quyết bài toán Đường chân trời sử dụng thuật toán Quét đường.
     * Sử dụng PriorityQueue để theo dõi chiều cao các tòa nhà đang hoạt động.
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        // 1. Decompose buildings into start and end events
        // 1. Phân tách các tòa nhà thành các sự kiện bắt đầu và kết thúc
        for (int[] b : buildings) {
            // Start point: height is negative
            // Điểm bắt đầu: chiều cao là âm
            heights.add(new int[] { b[0], -b[2] });
            // End point: height is positive
            // Điểm kết thúc: chiều cao là dương
            heights.add(new int[] { b[1], b[2] });
        }

        // 2. Sort events
        // Logic: Sort by x coordinate. If x is same, sort by height.
        // - Start (-H1) vs Start (-H2): Smaller (more negative, i.e., higher) comes
        // first.
        // - End (H1) vs End (H2): Smaller comes first.
        // - Start (-H1) vs End (H2): Negative comes first.
        // 2. Sắp xếp sự kiện
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // 3. Max Heap to store active heights.
        // Initial 0 represents the ground.
        // 3. Max Heap để lưu các chiều cao đang hoạt động.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prevMax = 0;

        // 4. Sweep line
        // 4. Quét đường
        for (int[] h : heights) {
            if (h[1] < 0) {
                // Start of building: add height (convert back to positive)
                // Bắt đầu tòa nhà: thêm chiều cao
                pq.offer(-h[1]);
            } else {
                // End of building: remove height
                // Kết thúc tòa nhà: xóa chiều cao
                pq.remove(h[1]);
            }

            int currMax = pq.peek();

            // If max height changes, it's a key point
            // Nếu chiều cao tối đa thay đổi, đó là một điểm chốt
            if (currMax != prevMax) {
                List<Integer> point = new ArrayList<>();
                point.add(h[0]);
                point.add(currMax);
                result.add(point);
                prevMax = currMax;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_SweepLine solution = new Solution_SweepLine();

        // Test Case 1: [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
        int[][] b1 = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
        System.out.println("Skyline 1: " + solution.getSkyline(b1));

        // Test Case 2: [[0,2,3],[2,5,3]]
        int[][] b2 = { { 0, 2, 3 }, { 2, 5, 3 } };
        System.out.println("Skyline 2: " + solution.getSkyline(b2));
    }
}
