package leetcode.P1040_MovingStonesUntilConsecutiveII;

import java.util.Arrays;

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;

        // Max moves calculation
        // Total empty slots inside range [stones[0], stones[n-1]] is (stones[n-1] -
        // stones[0] + 1 - n)
        // We lose the endpoint gap that is smaller because the first move destroys one
        // end.
        int totalGap = (stones[n - 1] - stones[0] + 1) - n;
        int gap1 = stones[1] - stones[0] - 1;
        int gapLast = stones[n - 1] - stones[n - 2] - 1;
        int maxMoves = totalGap - Math.min(gap1, gapLast);

        // Min moves calculation
        int minMoves = n;
        int j = 0;
        for (int i = 0; i < n; i++) {
            // Sliding window: stones[j]...stones[i] should fit in range of size n
            while (stones[i] - stones[j] + 1 > n) {
                j++;
            }

            int count = i - j + 1; // stones in window

            // Special case: n-1 consecutive stones, e.g. 1 2 3 4 ... 10
            if (count == n - 1 && stones[i] - stones[j] + 1 == n - 1) {
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - count);
            }
        }

        return new int[] { minMoves, maxMoves };
    }
}
