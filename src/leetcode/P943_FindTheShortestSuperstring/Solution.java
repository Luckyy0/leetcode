package leetcode.P943_FindTheShortestSuperstring;

import java.util.Arrays;

class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] overlap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                for (int len = Math.min(words[i].length(), words[j].length()); len > 0; len--) {
                    if (words[i].endsWith(words[j].substring(0, len))) {
                        overlap[i][j] = len;
                        break;
                    }
                }
            }
        }

        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];
        for (int[] row : dp)
            Arrays.fill(row, 1000000);

        for (int i = 0; i < n; i++)
            dp[1 << i][i] = words[i].length();

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0)
                    continue;
                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) != 0)
                        continue;
                    int nextMask = mask | (1 << j);
                    int nextLen = dp[mask][i] + words[j].length() - overlap[i][j];
                    if (nextLen < dp[nextMask][j]) {
                        dp[nextMask][j] = nextLen;
                        parent[nextMask][j] = i;
                    }
                }
            }
        }

        int minIdx = 0, fullMask = (1 << n) - 1;
        for (int i = 1; i < n; i++) {
            if (dp[fullMask][i] < dp[fullMask][minIdx])
                minIdx = i;
        }

        StringBuilder res = new StringBuilder();
        int curr = minIdx, mask = fullMask;
        while (mask > 0) {
            int prev = parent[mask][curr];
            if (mask == (1 << curr)) {
                res.insert(0, words[curr]);
            } else {
                res.insert(0, words[curr].substring(overlap[prev][curr]));
            }
            mask ^= (1 << curr);
            curr = prev;
        }

        return res.toString();
    }
}
