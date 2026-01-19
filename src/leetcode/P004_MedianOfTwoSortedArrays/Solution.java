package leetcode.P004_MedianOfTwoSortedArrays;

public class Solution {

    /**
     * Approach 1: Merge Sort Idea (Brute Force)
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     */
    public double findMedianSortedArraysMerge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < m)
            merged[k++] = nums1[i++];
        while (j < n)
            merged[k++] = nums2[j++];

        int totalLen = m + n;
        if (totalLen % 2 == 1) {
            return merged[totalLen / 2];
        } else {
            return (merged[totalLen / 2 - 1] + merged[totalLen / 2]) / 2.0;
        }
    }

    /**
     * Approach 2: Binary Search (Optimal)
     * Time Complexity: O(log(min(m, n)))
     * Space Complexity: O(1)
     */
    public double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysBinarySearch(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // We show too much of left side of nums1, move left
                right = partition1 - 1;
            } else {
                // We need more elements from nums1, move right
                left = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        runTest(solution, nums1, nums2, 2.0);

        // Test Case 2
        nums1 = new int[] { 1, 2 };
        nums2 = new int[] { 3, 4 };
        runTest(solution, nums1, nums2, 2.5);

        // Test Case 3: Zeros
        nums1 = new int[] { 0, 0 };
        nums2 = new int[] { 0, 0 };
        runTest(solution, nums1, nums2, 0.0);

        // Test Case 4: Empty array
        nums1 = new int[] {};
        nums2 = new int[] { 1 };
        runTest(solution, nums1, nums2, 1.0);

        // Test Case 5: Disjoint
        nums1 = new int[] { 100, 101 };
        nums2 = new int[] { 1, 2, 3 };
        // Merged: [1, 2, 3, 100, 101] -> Median 3
        runTest(solution, nums1, nums2, 3.0);
    }

    private static void runTest(Solution s, int[] n1, int[] n2, double expected) {
        System.out.println("Input: nums1 len=" + n1.length + ", nums2 len=" + n2.length);
        double resMerge = s.findMedianSortedArraysMerge(n1, n2);
        double resBS = s.findMedianSortedArraysBinarySearch(n1, n2);
        System.out.println("Merge: " + resMerge + " (Exp: " + expected + ")");
        System.out.println("BinarySearch: " + resBS + " (Exp: " + expected + ")");

        if (resMerge == expected && resBS == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("---------------------------------");
    }
}
