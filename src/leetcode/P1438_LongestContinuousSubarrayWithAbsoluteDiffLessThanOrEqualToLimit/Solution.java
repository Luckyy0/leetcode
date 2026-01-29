package leetcode.P1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxD.isEmpty() && maxD.peekLast() < nums[right])
                maxD.pollLast();
            while (!minD.isEmpty() && minD.peekLast() > nums[right])
                minD.pollLast();

            maxD.offerLast(nums[right]);
            minD.offerLast(nums[right]);

            while (maxD.peekFirst() - minD.peekFirst() > limit) {
                if (maxD.peekFirst() == nums[left])
                    maxD.pollFirst();
                if (minD.peekFirst() == nums[left])
                    minD.pollFirst();
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
