package leetcode.P1691_MaximumHeightByStackingCuboids;

import java.util.Arrays;

public class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int[] c : cuboids) {
            Arrays.sort(c);
        }

        // Sort cuboids based on dimensions to ensure we process smaller ones first (or
        // potential tops first)
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[2] - b[2];
        });

        int n = cuboids.length;
        int[] dp = new int[n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2]; // Base height: itself

            for (int j = 0; j < i; j++) {
                // Check if j fits on top of i? No, we sorted small to large.
                // So j is smaller than i (likely).
                // Can j be placed ON TOP of i? No, j is smaller.
                // If j is placed on i, then dimensions of j <= dimensions of i.
                // Condition: cuboids[j][0] <= cuboids[i][0] ...
                // If yes, then we can extend stack ending at j with i.
                // So dp[i] = max(dp[i], dp[j] + h[i]).
                // Here 'stack ending at j' means j is the BOTTOM-most of the previous stack.
                // Wait, "height of stack".
                // Let dp[i] be max height of stack where i is the BOTTOM-most block.
                // Or i is TOP-most?
                // Let's assume i is the BOTTOM block added to a stack formed by j.
                // Then j must fit on i. j <= i.
                // Since array is sorted, j < i implies j is generally smaller.
                // So j can be ON TOP of i.

                if (cuboids[j][0] <= cuboids[i][0] &&
                        cuboids[j][1] <= cuboids[i][1] &&
                        cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }
}
