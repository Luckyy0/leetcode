package leetcode.P891_SumOfSubsequenceWidths;

import java.util.Arrays;

class Solution {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long mod = 1_000_000_007;

        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++)
            pow2[i] = (pow2[i - 1] * 2) % mod;

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + nums[i] * pow2[i]) % mod;
            res = (res - nums[i] * pow2[n - 1 - i]) % mod;
        }

        return (int) ((res + mod) % mod);
    }
}
