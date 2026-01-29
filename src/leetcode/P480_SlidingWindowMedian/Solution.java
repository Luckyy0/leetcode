package leetcode.P480_SlidingWindowMedian;

import java.util.Comparator;
import java.util.TreeSet;

public class Solution {

    /**
     * Problem 480: Sliding Window Median
     * Approach: Two TreeSets (to simulate Heaps with O(log K) removal)
     * 
     * Time Complexity: O(N log K)
     * Space Complexity: O(K)
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        // Custom comparator to handle duplicate values using their indices
        Comparator<Integer> comparator = (a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[a], nums[b]);
            }
            return Integer.compare(a, b);
        };

        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        for (int i = 0; i < n; i++) {
            // Add new element
            left.add(i);
            right.add(left.pollFirst());
            if (right.size() > left.size()) {
                left.add(right.pollFirst());
            }

            // Remove old element
            if (i >= k) {
                int outIdx = i - k;
                if (left.contains(outIdx)) {
                    left.remove(outIdx);
                } else {
                    right.remove(outIdx);
                }

                // Rebalance
                if (left.size() < right.size()) {
                    left.add(right.pollFirst());
                } else if (left.size() > right.size() + 1) {
                    right.add(left.pollFirst());
                }
            }

            // Get median
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = (double) nums[left.first()];
                } else {
                    result[i - k + 1] = ((double) nums[left.first()] + (double) nums[right.first()]) / 2.0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,3,-1,-3,5,3,6,7], k = 3 -> [1.0, -1.0, -1.0, 3.0, 5.0, 6.0]
        int[] nums1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        runTest(sol, nums1, 3);
    }

    private static void runTest(Solution sol, int[] nums, int k) {
        double[] result = sol.medianSlidingWindow(nums, k);
        System.out.println("Result: " + java.util.Arrays.toString(result));
    }
}
