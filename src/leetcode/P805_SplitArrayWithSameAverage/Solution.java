package leetcode.P805_SplitArrayWithSameAverage;

import java.util.Arrays;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return false;
        int sum = 0;
        for (int x : nums)
            sum += x;

        // dp[i] is a set of all possible sums of i elements
        // dp[i] la tap hop cac tong co the cua i phan tu
        // Using BitSet for efficiency
        java.util.BitSet[] dp = new java.util.BitSet[n / 2 + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = new java.util.BitSet();
        dp[0].set(0);

        for (int x : nums) {
            for (int i = n / 2; i >= 1; i--) {
                // dp[i] |= (dp[i-1] << x)
                // Unfortunately BitSet doesn't support shift easily, but we can iterate
                // and BitSet is optimized for large booleans.
                // Alternatively, use a simplified DP for this problem:
                // Many solutions use BitSet to represent sums.
                // For simplicity in this implementation, we use bitwise manual updates.
            }
        }

        // Re-implementing with BitSet logic
        for (int x : nums) {
            for (int i = n / 2; i >= 1; i--) {
                java.util.BitSet prev = dp[i - 1];
                java.util.BitSet curr = dp[i];
                for (int s = prev.nextSetBit(0); s >= 0; s = prev.nextSetBit(s + 1)) {
                    curr.set(s + x);
                }
            }
        }

        for (int k = 1; k <= n / 2; k++) {
            if ((sum * k) % n == 0 && dp[k].get(sum * k / n)) {
                return true;
            }
        }

        return false;
    }
}
