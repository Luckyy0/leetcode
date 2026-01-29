package leetcode.P1121_DivideArrayIntoIncreasingSequences;

class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int maxFreq = 0;
        int currentFreq = 0;
        int prev = -1;

        for (int x : nums) {
            if (x == prev) {
                currentFreq++;
            } else {
                currentFreq = 1;
                prev = x;
            }
            maxFreq = Math.max(maxFreq, currentFreq);
        }

        // Since array is non-decreasing, duplicate elements are contiguous.
        // We need maxFreq groups.
        // Each group must have >= K elements.
        // Total elements needed >= maxFreq * K.

        return (long) nums.length >= (long) K * maxFreq;
    }
}
