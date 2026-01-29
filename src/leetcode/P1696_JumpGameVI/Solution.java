package leetcode.P1696_JumpGameVI;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        for (int i = 1; i < n; i++) {
            // Remove out of range
            if (deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            // Current max is at front
            dp[i] = nums[i] + dp[deque.peekFirst()];

            // Maintain monotonic decreasing deque
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        return dp[n - 1];
    }
}
