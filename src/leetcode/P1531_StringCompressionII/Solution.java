package leetcode.P1531_StringCompressionII;

import java.util.Arrays;

class Solution {
    int[][] memo;
    char[] chars;
    int n;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.chars = s.toCharArray();
        this.n = s.length();
        this.memo = new int[n][k + 1];
        for (int[] r : memo)
            Arrays.fill(r, -1);

        return dp(0, k);
    }

    private int dp(int i, int k) {
        if (k < 0)
            return 1000; // Impossible
        if (i == n || n - i <= k)
            return 0; // Can delete rest

        if (memo[i][k] != -1)
            return memo[i][k];

        // Option 1: Delete s[i]
        int res = dp(i + 1, k - 1);

        // Option 2: Keep s[i] and form a block including future s[i] chars
        int same = 0;
        int diff = 0;

        for (int j = i; j < n; j++) {
            if (chars[j] == chars[i]) {
                same++;
            } else {
                diff++;
            }

            if (diff > k)
                break;

            int len = 1;
            if (same >= 100)
                len = 4;
            else if (same >= 10)
                len = 3;
            else if (same >= 2)
                len = 2;

            res = Math.min(res, len + dp(j + 1, k - diff));
        }

        return memo[i][k] = res;
    }
}
