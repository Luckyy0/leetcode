package leetcode.P1498_NumberOfSubsequencesThatSatisfyTheGivenSumCondition;

import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int MOD = 1_000_000_007;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int res = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                res = (res + pow[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
