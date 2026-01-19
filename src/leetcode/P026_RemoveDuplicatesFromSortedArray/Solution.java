package leetcode.P026_RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 26: Remove Duplicates from Sorted Array
     * Approach: Two Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            // We compare with the previous element in the original array stream
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 1, 2 }, 2, new int[] { 1, 2 });
        runTest(solution, new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }, 5, new int[] { 0, 1, 2, 3, 4 });
    }

    private static void runTest(Solution s, int[] input, int expectedK, int[] expectedNums) {
        System.out.println("Input: " + Arrays.toString(input));

        // Clone input to keep original for display if needed (though we modify
        // in-place)
        int[] nums = input.clone();

        int k = s.removeDuplicates(nums);

        System.out.println("Output k: " + k + " (Expected: " + expectedK + ")");

        // Verify first k elements
        int[] resultNums = Arrays.copyOf(nums, k);
        System.out.println("Output nums (first k): " + Arrays.toString(resultNums));

        if (k == expectedK && Arrays.equals(resultNums, expectedNums)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
