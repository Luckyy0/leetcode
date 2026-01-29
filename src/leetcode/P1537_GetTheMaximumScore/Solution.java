package leetcode.P1537_GetTheMaximumScore;

class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        long sum1 = 0, sum2 = 0;
        long res = 0;
        int MOD = 1_000_000_007;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                // Common point
                res = (res + Math.max(sum1, sum2) + nums1[i]) % MOD;
                sum1 = 0;
                sum2 = 0;
                i++;
                j++; // Skip common point in both to avoid double count or re-adding
                // Wait. We added common value to res. So next accumulation starts 0.
            }
        }

        while (i < n)
            sum1 += nums1[i++];
        while (j < m)
            sum2 += nums2[j++];

        res = (res + Math.max(sum1, sum2)) % MOD;

        return (int) res;
    }
}
