package leet_code.Problem_973_Medium_K_Closest_Points_to_Origin;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem 973: K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class Solution {

    /**
     * Finds K closest points using Sort.
     * Strategy: Custom Comparator Sorting.
     * 
     * @param points Array of points.
     * @param k      Number of points to return.
     * @return Array of K closest points.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sắp xếp mảng `points` dựa trên khoảng cách Euclide bình phương đến
     *         gốc tọa độ `(0, 0)`.
     *         Khoảng cách bình phương là `x^2 + y^2`.
     *         2. Ta không cần tính căn bậc hai vì hàm căn bậc hai là đơn điệu tăng.
     *         So sánh `d1^2 < d2^2` tương đương `d1 < d2`.
     *         3. Sử dụng `Arrays.sort` với Comparator tùy chỉnh.
     *         4. Trả về `k` phần tử đầu tiên của mảng đã sắp xếp.
     */
    public int[][] kClosest(int[][] points, int k) {
        // Sort based on squared distance: x^2 + y^2
        Arrays.sort(points, (a, b) -> Integer.compare(
                a[0] * a[0] + a[1] * a[1],
                b[0] * b[0] + b[1] * b[1]));

        // Return first k elements
        return Arrays.copyOfRange(points, 0, k);
    }

    /**
     * Alternative approaches:
     * 1. Max Heap (PriorityQueue): Maintain heap of size K. O(N log K). Good for
     * large N small K.
     * 2. QuickSelect: Find K-th element in O(N) average.
     */
    public int[][] kClosestHeap(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]) // Max heap based on
                                                                                                // distance
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the farthest point
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] p1 = { { 1, 3 }, { -2, 2 } };
        int[][] r1 = sol.kClosest(p1, 1);
        System.out.println("Result 1: " + Arrays.deepToString(r1)); // [[-2, 2]]

        int[][] p2 = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int[][] r2 = sol.kClosest(p2, 2);
        System.out.println("Result 2: " + Arrays.deepToString(r2)); // [[3, 3], [-2, 4]] or similar order
    }
}
