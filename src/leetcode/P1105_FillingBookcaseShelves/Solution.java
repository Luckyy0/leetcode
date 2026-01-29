package leetcode.P1105_FillingBookcaseShelves;

import java.util.Arrays;

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int currentWidth = 0;
            int maxHeight = 0;

            // Try last shelf containing books[j-1]...books[i-1] (indices j..i in 1-based,
            // j-1..i-1 in 0-based)
            for (int j = i; j > 0; j--) {
                int[] book = books[j - 1];
                currentWidth += book[0];

                if (currentWidth > shelfWidth)
                    break;

                maxHeight = Math.max(maxHeight, book[1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight);
            }
        }

        return dp[n];
    }
}
