package leet_code.Problem_487_Medium_Max_Consecutive_Ones_II;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_SlidingWindow {

    /**
     * Finds max consecutive 1s with at most one 0 flip.
     * Strategy: Sliding window. Expand right, shrink left if zeros > 1.
     * Time: O(N), Space: O(1).
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int zeros = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // Follow up: Stream solution using Queue to store index of zeros
    public int findMaxConsecutiveOnesStream(int[] nums) {
        int maxLen = 0;
        int left = 0;
        // Stores indices of zeros inside current window
        Queue<Integer> zeroIndices = new LinkedList<>();
        int k = 1; // max flips allowed

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroIndices.offer(right);
            }

            if (zeroIndices.size() > k) {
                // Move left past the oldest zero
                left = zeroIndices.poll() + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution_SlidingWindow solution = new Solution_SlidingWindow();
        int[] nums = { 1, 0, 1, 1, 0 };
        System.out.println("Result: " + solution.findMaxConsecutiveOnes(nums)); // 4
    }
}
