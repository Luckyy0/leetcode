package leetcode.P1283_FindTheSmallestDivisorGivenAThreshold;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1_000_000; // sufficiently large, or max(nums)
        // Actually max value in nums is 10^6 max

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid) <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int check(int[] nums, int divisor) {
        int sum = 0;
        for (int x : nums) {
            sum += (x + divisor - 1) / divisor;
        }
        return sum;
    }
}
