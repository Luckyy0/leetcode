package leetcode.P974_SubarraySumsDivisibleByK;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] counts = new int[k];
        counts[0] = 1;
        int res = 0, sum = 0;
        for (int x : nums) {
            sum = (sum + x) % k;
            if (sum < 0)
                sum += k; // Normalized remainder
            res += counts[sum];
            counts[sum]++;
        }
        return res;
    }
}
