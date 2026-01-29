package leetcode.P689_MaximumSumOf3NonOverlappingSubarrays;

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n - k + 1];
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            if (i >= k)
                s -= nums[i - k];
            if (i >= k - 1)
                sums[i - k + 1] = s;
        }

        int[] left = new int[sums.length];
        int best = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[best])
                best = i;
            left[i] = best;
        }

        int[] right = new int[sums.length];
        best = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[best])
                best = i; // >= to get lexicographically smallest
            right[i] = best;
        }

        int[] ans = new int[] { -1, -1, -1 };
        for (int j = k; j < sums.length - k; j++) {
            int l = left[j - k], r = right[j + k];
            if (ans[0] == -1 || sums[l] + sums[j] + sums[r] > sums[ans[0]] + sums[ans[1]] + sums[ans[2]]) {
                ans[0] = l;
                ans[1] = j;
                ans[2] = r;
            }
        }
        return ans;
    }
}
