package leetcode.P088_MergeSortedArray;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 88: Merge Sorted Array
     * Approach: Three Pointers (Backwards)
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1_1 = { 1, 2, 3, 0, 0, 0 };
        int m1 = 3;
        int[] nums2_1 = { 2, 5, 6 };
        int n1 = 3;
        runTest(solution, nums1_1, m1, nums2_1, n1, new int[] { 1, 2, 2, 3, 5, 6 });

        int[] nums1_2 = { 1 };
        int m2 = 1;
        int[] nums2_2 = {};
        int n2 = 0;
        runTest(solution, nums1_2, m2, nums2_2, n2, new int[] { 1 });

        int[] nums1_3 = { 0 };
        int m3 = 0;
        int[] nums2_3 = { 1 };
        int n3 = 1;
        runTest(solution, nums1_3, m3, nums2_3, n3, new int[] { 1 });
    }

    private static void runTest(Solution s, int[] nums1, int m, int[] nums2, int n, int[] expected) {
        System.out.println("Input nums1: " + Arrays.toString(nums1) + ", m=" + m + ", nums2: " + Arrays.toString(nums2)
                + ", n=" + n);
        s.merge(nums1, m, nums2, n);
        System.out.println("Output: " + Arrays.toString(nums1) + " (Expected: " + Arrays.toString(expected) + ")");

        if (Arrays.equals(nums1, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
