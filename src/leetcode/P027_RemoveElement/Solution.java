package leetcode.P027_RemoveElement;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 27: Remove Element
     * Approach: Two Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 3, 2, 2, 3 }, 3, 2);
        runTest(solution, new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2, 5);
    }

    private static void runTest(Solution s, int[] input, int val, int expectedK) {
        System.out.println("Input: " + Arrays.toString(input) + ", val = " + val);
        int[] nums = input.clone();

        int k = s.removeElement(nums, val);

        System.out.println("Output k: " + k + " (Expected: " + expectedK + ")");

        // Check first k elements don't contain val (and simple count)
        boolean pass = (k == expectedK);
        for (int i = 0; i < k; i++) {
            if (nums[i] == val)
                pass = false;
        }

        if (pass) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
