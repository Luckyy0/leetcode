package leetcode.P2172_MaximumANDSumOfArray;

import java.util.Arrays;

public class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int n = nums.length;
        int maxMask = (int) Math.pow(3, numSlots);
        int[] dp = new int[maxMask];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int maxScore = 0;

        // Iterate masks. Since we only add numbers, increasing mask order works.
        // But we need to know WHICH number we are placing.
        // We can deduce 'k' (index in nums) from the number of items in mask.

        for (int mask = 0; mask < maxMask; mask++) {
            if (dp[mask] == -1)
                continue;

            int count = 0;
            int temp = mask;
            for (int j = 0; j < numSlots; j++) {
                count += temp % 3;
                temp /= 3;
            }

            if (count >= n) {
                maxScore = Math.max(maxScore, dp[mask]);
                continue;
            }

            // Try placing nums[count] into slot j (1-based index is j+1)
            int val = nums[count];
            int pow3 = 1;
            int t_mask = mask;

            for (int j = 1; j <= numSlots; j++) {
                int slotUsage = t_mask % 3;
                t_mask /= 3; // Shift for next iteration logic

                if (slotUsage < 2) {
                    int nextMask = mask + pow3;
                    int score = val & j;
                    dp[nextMask] = Math.max(dp[nextMask], dp[mask] + score);
                    maxScore = Math.max(maxScore, dp[nextMask]);
                }

                pow3 *= 3;
            }
        }

        return maxScore;
    }
}
