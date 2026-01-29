package leetcode.P2163_MinimumDifferenceInSumsAfterRemovalOfElements;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m / 3;

        long[] minSumLeft = new long[m];
        // Max Heap needed to keep smallest n elements
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        long currentSum = 0;

        for (int i = 0; i < m; i++) {
            currentSum += nums[i];
            leftHeap.offer(nums[i]);
            if (leftHeap.size() > n) {
                currentSum -= leftHeap.poll();
            }
            if (leftHeap.size() == n) {
                minSumLeft[i] = currentSum;
            }
        }

        long[] maxSumRight = new long[m];
        // Min Heap needed to keep largest n elements
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        currentSum = 0;

        for (int i = m - 1; i >= 0; i--) {
            currentSum += nums[i];
            rightHeap.offer(nums[i]);
            if (rightHeap.size() > n) {
                currentSum -= rightHeap.poll();
            }
            if (rightHeap.size() == n) {
                maxSumRight[i] = currentSum;
            }
        }

        long minDiff = Long.MAX_VALUE;
        // Split point can be after index i.
        // i ranges from n-1 to 2n-1.
        // Left uses 0..i. Right uses i+1..m-1.

        for (int i = n - 1; i < 2 * n; i++) {
            minDiff = Math.min(minDiff, minSumLeft[i] - maxSumRight[i + 1]);
        }

        return minDiff;
    }
}
