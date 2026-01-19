package leetcode.P041_FirstMissingPositive;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 41: First Missing Positive
     * Approach: Cycle Sort (In-place)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // While nums[i] is in [1, n] and is not at correct position
            // Trong khi nums[i] nằm trong [1, n] và không ở đúng vị trí
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 2, 0 }, 3);
        runTest(solution, new int[] { 3, 4, -1, 1 }, 2);
        runTest(solution, new int[] { 7, 8, 9, 11, 12 }, 1);
        runTest(solution, new int[] { 1, 2, 3 }, 4);
    }

    private static void runTest(Solution s, int[] input, int expected) {
        System.out.println("Input: " + Arrays.toString(input));

        // Clone to preserve original input for printing if needed,
        // though logic modifies it.
        int[] nums = input.clone();

        int result = s.firstMissingPositive(nums);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
