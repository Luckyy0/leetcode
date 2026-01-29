package leetcode.P2106_MaximumFruitsHarvestedAfterAtMostKSteps;

public class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0;
        int currentFruits = 0;
        int l = 0;

        // Sliding window [l, r]
        // But indices refer to the fruits array index, not position directly (though we
        // limit based on position)

        for (int r = 0; r < n; r++) {
            currentFruits += fruits[r][1];

            // While window [l, r] cost > k, shrink from left
            while (l <= r) {
                int leftPos = fruits[l][0];
                int rightPos = fruits[r][0];

                // Calculate cost
                // Case 1: All on right of start
                // Case 2: All on left of start
                // Case 3: Crossing start

                long cost; // Use long to prevent overflow although pos <= 2*10^5

                if (rightPos <= startPos) {
                    cost = startPos - leftPos;
                } else if (leftPos >= startPos) {
                    cost = rightPos - startPos;
                } else {
                    int leftDist = startPos - leftPos;
                    int rightDist = rightPos - startPos;
                    cost = Math.min(leftDist, rightDist) + (rightPos - leftPos);
                }

                if (cost > k) {
                    currentFruits -= fruits[l][1];
                    l++;
                } else {
                    break;
                }
            }

            maxFruits = Math.max(maxFruits, currentFruits);
        }

        return maxFruits;
    }
}
