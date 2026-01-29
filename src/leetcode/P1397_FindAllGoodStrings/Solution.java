package leetcode.P1397_FindAllGoodStrings;

import java.util.Arrays;

class Solution {
    int n, m;
    int MOD = 1_000_000_007;
    int[] next;
    Integer[][][][] memo;
    String s1, s2, evil;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n;
        this.m = evil.length();
        this.s1 = s1;
        this.s2 = s2;
        this.evil = evil;

        // KMP Preprocessing
        next = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && evil.charAt(i) != evil.charAt(j))
                j = next[j - 1];
            if (evil.charAt(i) == evil.charAt(j))
                j++;
            next[i] = j;
        }

        memo = new Integer[n][m][2][2];
        return dfs(0, 0, true, true);
    }

    private int dfs(int idx, int match, boolean tight1, boolean tight2) {
        if (match == m)
            return 0; // Contains evil
        if (idx == n)
            return 1;

        if (memo[idx][match][tight1 ? 1 : 0][tight2 ? 1 : 0] != null) {
            return memo[idx][match][tight1 ? 1 : 0][tight2 ? 1 : 0];
        }

        char start = tight1 ? s1.charAt(idx) : 'a';
        char end = tight2 ? s2.charAt(idx) : 'z';

        long count = 0;

        for (char c = start; c <= end; c++) {
            int nextMatch = match;
            while (nextMatch > 0 && c != evil.charAt(nextMatch)) {
                nextMatch = next[nextMatch - 1];
            }
            if (c == evil.charAt(nextMatch)) {
                nextMatch++;
            }

            boolean nextTight1 = tight1 && (c == start);
            boolean nextTight2 = tight2 && (c == end);

            count = (count + dfs(idx + 1, nextMatch, nextTight1, nextTight2)) % MOD;
        }

        return memo[idx][match][tight1 ? 1 : 0][tight2 ? 1 : 0] = (int) count;
    }
}
