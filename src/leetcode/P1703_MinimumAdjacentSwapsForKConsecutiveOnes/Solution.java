package leetcode.P1703_MinimumAdjacentSwapsForKConsecutiveOnes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minMoves(int[] nums, int k) {
        List<Long> p = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                p.add((long) i);
            }
        }

        int n = p.size();
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = p.get(i) - i;
        }

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + A[i];
        }

        long minCost = Long.MAX_VALUE;

        for (int i = 0; i <= n - k; i++) {
            // Window from i to i + k - 1
            // Median is at i + k / 2
            int mid = i + k / 2;
            long medianVal = A[mid];

            // Left part: i to mid-1 (or mid if k odd, duplicate median cost is 0)
            // Right part: mid+1 to i+k-1

            // Formula: sum(|x - median|) = (sumRight - countRight * median) + (countLeft *
            // median - sumLeft)

            // Range Left: [i, mid-1]
            // Range Right: [mid+1, i+k-1]
            // Note: A[mid] contribution is 0, can exclude or include.

            long sumLeft = prefix[mid] - prefix[i];
            long countLeft = mid - i;

            long sumRight = prefix[i + k] - prefix[mid + 1];
            long countRight = (i + k) - (mid + 1);

            long cost = (countLeft * medianVal - sumLeft) + (sumRight - countRight * medianVal);
            minCost = Math.min(minCost, cost);
        }

        return (int) minCost;
    }
}
