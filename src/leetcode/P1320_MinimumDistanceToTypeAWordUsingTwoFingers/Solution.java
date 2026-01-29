package leetcode.P1320_MinimumDistanceToTypeAWordUsingTwoFingers;

import java.util.Arrays;

class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        // dp[other] means min cost to type up to current char, with one finger at
        // current char and other at 'other'
        int[] dp = new int[27];
        Arrays.fill(dp, 0); // Cost 0 for first char roughly handled by loop logic

        // Actually for i=0, we place one finger at word[0], cost 0. Other is 26.
        // So after step 0: dp[26] = 0. All others infinity.
        Arrays.fill(dp, 1000000);
        dp[26] = 0;

        for (int i = 0; i < n - 1; i++) {
            int[] nextDp = new int[27];
            Arrays.fill(nextDp, 1000000);

            int curr = word.charAt(i) - 'A';
            int next = word.charAt(i + 1) - 'A';
            int d_curr_next = dist(curr, next);

            for (int other = 0; other <= 26; other++) {
                if (dp[other] >= 1000000)
                    continue;

                // Option 1: Finger at curr moves to next
                // Other finger stays at 'other'
                // Cost: dp[other] + dist(curr, next)
                nextDp[other] = Math.min(nextDp[other], dp[other] + d_curr_next);

                // Option 2: Finger at 'other' moves to next
                // Finger at 'curr' becomes the new 'other'
                // Cost: dp[other] + dist(other, next)
                int d_other_next = dist(other, next);
                nextDp[curr] = Math.min(nextDp[curr], dp[other] + d_other_next);
            }
            dp = nextDp;
        }

        int min = Integer.MAX_VALUE;
        for (int x : dp)
            min = Math.min(min, x);
        return min;
    }

    private int dist(int a, int b) {
        if (a == 26 || b == 26)
            return 0; // Hovering
        int r1 = a / 6, c1 = a % 6;
        int r2 = b / 6, c2 = b % 6;
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
