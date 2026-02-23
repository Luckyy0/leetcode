package leet_code.Problem_862_Hard_Shortest_Subarray_with_Sum_at_Least_K;

import java.util.*;

/**
 * Problem 862: Shortest Subarray with Sum at Least K
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 */
public class Solution {

    /**
     * Finds the shortest subarray with sum >= k using Monotonic Deque.
     * Strategy: Use prefix sum mapped into a sliding window maintained by a deque.
     * 
     * @param nums Input array (can contain negative numbers).
     * @param k    Target sum.
     * @return Minimum length or -1.
     * 
     *         Tóm tắt chiến lược:
     *         Vì mảng có số âm, chúng ta không dùng 2 con trỏ thông thường được.
     *         Thay vào đó, dùng mảng Prefix Sum và Deque để giữ các chỉ số có
     *         giá trị tổng tiền tố tăng dần.
     *         1. Xóa từ đầu hàng đợi nếu khoảng cách tổng đạt K.
     *         2. Xóa từ cuối hàng đợi nếu giá trị mới nhỏ hơn giá trị cũ (vì giá
     *         trị mới
     *         là khởi điểm tốt hơn để trừ đi tạo ra tổng K).
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // Using long to prevent overflow
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = n + 1;
        // Deque stores indices of prefixSum
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // Check if current prefixSum minus the smallest previous prefixSum is >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= (long) k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Keep the deque monotonically increasing.
            // If prefixSum[i] is smaller than prefixSum[deque.last],
            // prefixSum[i] is a better starting point.
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLength <= n ? minLength : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.shortestSubarray(new int[] { 1 }, 1)); // 1
        System.out.println("Result: " + sol.shortestSubarray(new int[] { 1, 2 }, 4)); // -1
        System.out.println("Result: " + sol.shortestSubarray(new int[] { 2, -1, 2 }, 3)); // 3
    }
}
