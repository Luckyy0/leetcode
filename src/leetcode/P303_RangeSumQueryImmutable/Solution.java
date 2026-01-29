package leetcode.P303_RangeSumQueryImmutable;

public class Solution {

    /**
     * Problem 303: Range Sum Query - Immutable
     * Approach: Prefix Sum
     * 
     * Time Complexity: O(1) query, O(N) init
     * Space Complexity: O(N)
     */
    public static class NumArray {

        private int[] prefixSum;

        public NumArray(int[] nums) {
            int n = nums.length;
            prefixSum = new int[n + 1];
            // prefixSum[i] stores sum of nums[0...i-1]
            // prefixSum[0] = 0
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            // Sum inclusive [left, right]
            // sum(0..right) - sum(0..left-1)
            // prefixSum[right+1] - prefixSum[left]
            return prefixSum[right + 1] - prefixSum[left];
        }
    }

    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray numArray = new NumArray(nums);

        // sumRange(0, 2) -> 1
        runTest(numArray, 0, 2, 1);

        // sumRange(2, 5) -> -1
        runTest(numArray, 2, 5, -1);

        // sumRange(0, 5) -> -3
        runTest(numArray, 0, 5, -3);
    }

    private static void runTest(NumArray na, int l, int r, int expected) {
        int result = na.sumRange(l, r);
        System.out.println("Range [" + l + ", " + r + "] -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
