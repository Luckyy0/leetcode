package leetcode.P239_SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    /**
     * Problem 239: Sliding Window Maximum
     * Approach: Monotonic Queue (Deque)
     * 
     * Theoretical Basis:
     * - Maintain indices of elements in decreasing order of value.
     * - Front of deque is always the max.
     * - Remove old indices from front.
     * - Remove smaller elements from back when adding new element.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(K)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // result index

        // Store indices
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 1. Remove elements out of the current window from the front
            // The window is [i-k+1, i]. So valid indices are >= i-k+1.
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. Remove elements smaller than current element from the back
            // They are useless because current element is larger and newer.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. Add current element to the back
            deque.offerLast(i);

            // 4. If window is fully formed, take the max (front)
            if (i >= k - 1) {
                result[ri++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,3,-1,-3,5,3,6,7], k=3 -> [3,3,5,5,6,7]
        runTest(solution, new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3, new int[] { 3, 3, 5, 5, 6, 7 });

        // [1], k=1 -> [1]
        runTest(solution, new int[] { 1 }, 1, new int[] { 1 });

        // [9, 11], k=2 -> [11]
        runTest(solution, new int[] { 9, 11 }, 2, new int[] { 11 });

        // Decreasing: [5,4,3,2,1], k=3 -> [5,4,3]
        runTest(solution, new int[] { 5, 4, 3, 2, 1 }, 3, new int[] { 5, 4, 3 });
    }

    private static void runTest(Solution s, int[] nums, int k, int[] expected) {
        int[] result = s.maxSlidingWindow(nums, k);
        System.out.print("Input: " + Arrays.toString(nums));
        if (nums.length > 10)
            System.out.print("...");
        System.out.println(", k=" + k);
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Expected: " + Arrays.toString(expected));

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
