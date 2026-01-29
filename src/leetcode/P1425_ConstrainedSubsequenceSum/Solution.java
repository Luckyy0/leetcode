package leetcode.P1425_ConstrainedSubsequenceSum;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Remove outdated indices
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            // Get max from previous window
            int prevMax = dq.isEmpty() ? 0 : dp[dq.peekFirst()];
            dp[i] = nums[i] + Math.max(0, prevMax);
            max = Math.max(max, dp[i]);

            // Add current to deque
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        return max;
    }
}
