package leetcode.P960_DeleteColumnsToMakeSortedIII;

import java.util.Arrays;

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                boolean ok = true;
                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return m - maxLen;
    }
}
