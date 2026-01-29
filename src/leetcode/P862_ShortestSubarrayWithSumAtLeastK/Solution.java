package leetcode.P862_ShortestSubarrayWithSumAtLeastK;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] p = new long[n + 1];
        for (int i = 0; i < n; i++)
            p[i + 1] = p[i] + nums[i];

        int minLen = n + 1;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && p[i] - p[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - dq.pollFirst());
            }
            while (!dq.isEmpty() && p[i] <= p[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        return minLen <= n ? minLen : -1;
    }
}
