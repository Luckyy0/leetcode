package leetcode.P189_RotateArray;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 189: Rotate Array
     * Approach: Triple Reversal (In-place)
     * 
     * Theoretical Basis:
     * - Reversing the whole array, then the first k elements, then the rest
     * effectively rotates the array with O(1) extra space.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0)
            return;

        // 1. Reverse entire array
        reverse(nums, 0, n - 1);
        // 2. Reverse the first k elements
        reverse(nums, 0, k - 1);
        // 3. Reverse the rest
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] n1 = { 1, 2, 3, 4, 5, 6, 7 };
        solution.rotate(n1, 3);
        System.out.println("Test 1: " + Arrays.toString(n1)); // Expected: [5, 6, 7, 1, 2, 3, 4]

        // Example 2
        int[] n2 = { -1, -100, 3, 99 };
        solution.rotate(n2, 2);
        System.out.println("Test 2: " + Arrays.toString(n2)); // Expected: [3, 99, -1, -100]
    }
}
