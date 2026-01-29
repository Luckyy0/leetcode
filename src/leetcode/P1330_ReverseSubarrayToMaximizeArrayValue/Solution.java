package leetcode.P1330_ReverseSubarrayToMaximizeArrayValue;

class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int total = 0;
        int minHigh = Integer.MAX_VALUE;
        int maxLow = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            total += Math.abs(a - b);

            minHigh = Math.min(minHigh, Math.max(a, b));
            maxLow = Math.max(maxLow, Math.min(a, b));
        }

        int diff = Math.max(0, 2 * (maxLow - minHigh));

        // Check boundary cases: reverse [0, i] or [i, n-1]
        // This is essentially changing one pair (0, something) to (0, something_else)
        // visually?
        // No, reversing [0, k]:
        // Old: ... | nums[k]-nums[k+1] | ...
        // New: ... | nums[0]-nums[k+1] | ... (nums[0] is now adjacent to nums[k+1])
        // Change = |nums[0] - nums[k+1]| - |nums[k] - nums[k+1]|
        for (int i = 0; i < n - 1; i++) {
            // Reverse [0, i]
            diff = Math.max(diff, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            // Reverse [i+1, n-1]
            // Old boundary (i, i+1) becomes (i, n-1)
            diff = Math.max(diff, Math.abs(nums[i] - nums[n - 1]) - Math.abs(nums[i] - nums[i + 1]));
        }

        return total + diff;
    }
}
