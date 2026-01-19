package leetcode.P164_MaximumGap;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 164: Maximum Gap
     * Approach: Bucket Sort Logic (Pigeonhole Principle)
     * 
     * Theoretical Basis:
     * - The maximum gap >= (max - min) / (N - 1).
     * - Let bucketSize = (max - min) / (N - 1).
     * - Max gap must occur between buckets.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max)
            return 0;

        // Calculate bucket size and count
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Fill buckets
        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }

        // Scan buckets for the gap
        int maxGap = 0;
        int prevMax = min;

        for (int i = 0; i < bucketCount; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE)
                continue;

            // Gap is current min - previous max
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,6,9,1] -> sorted [1,3,6,9] -> gaps [2, 3, 3] -> max gap 3
        runTest(solution, new int[] { 3, 6, 9, 1 }, 3);

        // [10] -> 0
        runTest(solution, new int[] { 10 }, 0);

        // [1, 10] -> 9
        runTest(solution, new int[] { 1, 10 }, 9);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.maximumGap(nums);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
