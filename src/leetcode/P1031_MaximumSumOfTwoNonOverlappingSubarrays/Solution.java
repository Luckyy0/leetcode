package leetcode.P1031_MaximumSumOfTwoNonOverlappingSubarrays;

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        return Math.max(maxSum(prefixSum, firstLen, secondLen), maxSum(prefixSum, secondLen, firstLen));
    }

    private int maxSum(int[] p, int L, int M) {
        int maxSumL = 0;
        int res = 0;
        for (int i = L + M; i < p.length; i++) {
            // p[i] is sum up to i (exclusive? no inclusive index in loop is i-1)
            // p array size n+1. p[k] is sum of first k elements.
            // Sum of L subarray ending at i-M: sum range [i-M-L, i-M) -> p[i-M] - p[i-M-L]
            int curL = p[i - M] - p[i - M - L];
            int curM = p[i] - p[i - M];
            maxSumL = Math.max(maxSumL, curL);
            res = Math.max(res, maxSumL + curM);
        }
        return res;
    }
}
