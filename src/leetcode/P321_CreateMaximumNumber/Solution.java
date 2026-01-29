package leetcode.P321_CreateMaximumNumber;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 321: Create Maximum Number
     * Approach: Max Subsequence + Merge
     * 
     * Time Complexity: O(K^3) worst case
     * Space Complexity: O(K)
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxRes = new int[k];

        // Iterate possible split of k between nums1 and nums2
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] sub1 = maxSubsequence(nums1, i);
            int[] sub2 = maxSubsequence(nums2, k - i);
            int[] candidate = merge(sub1, sub2);

            if (greater(candidate, 0, maxRes, 0)) {
                maxRes = candidate;
            }
        }

        return maxRes;
    }

    // Get max subsequence of length k from nums
    private int[] maxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1;
        int drop = nums.length - k; // allowed drops

        for (int num : nums) {
            while (top >= 0 && stack[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                drop--; // Cannot push, effectively dropped
            }
        }
        return stack;
    }

    // Merge two arrays to get largest number
    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, p = 0;

        while (i < nums1.length || j < nums2.length) {
            if (greater(nums1, i, nums2, j)) {
                res[p++] = nums1[i++];
            } else {
                res[p++] = nums2[j++];
            }
        }

        return res;
    }

    // Returns true if nums1[i...] > nums2[j...] lexicographically
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        // If one ends, the non-ended one is technically not "greater" ?
        // 9 > empty? Yes. Comparison logic:
        // if j reached end, i < end -> true.
        // if i reached end -> false.

        if (j == nums2.length)
            return true;
        if (i == nums1.length)
            return false;

        return nums1[i] > nums2[j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
        // Output: [9,8,6,5,3]
        runTest(solution, new int[] { 3, 4, 6, 5 }, new int[] { 9, 1, 2, 5, 8, 3 }, 5, new int[] { 9, 8, 6, 5, 3 });

        // [6,7], [6,0,4], k=5
        // Output: [6,7,6,0,4]
        runTest(solution, new int[] { 6, 7 }, new int[] { 6, 0, 4 }, 5, new int[] { 6, 7, 6, 0, 4 });

        // [3,9], [8,9], k=3
        // Output: [9,8,9]
        runTest(solution, new int[] { 3, 9 }, new int[] { 8, 9 }, 3, new int[] { 9, 8, 9 });
    }

    private static void runTest(Solution s, int[] n1, int[] n2, int k, int[] expected) {
        int[] result = s.maxNumber(n1, n2, k);
        System.out.println("Result: " + Arrays.toString(result) + " (Expected: " + Arrays.toString(expected) + ")");
        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
